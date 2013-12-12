/* DO NOT EDIT THIS FILE - IT IS MACHINE GENERATED */

package com.googlecode.javacpp;

import com.googlecode.javacpp.*;
import com.googlecode.javacpp.annotation.*;
import java.nio.*;

import static com.googlecode.javacpp.opencv_core.*;
import static com.googlecode.javacpp.opencv_imgproc.*;
import static com.googlecode.javacpp.opencv_highgui.*;

public class opencv_calib3d extends com.googlecode.javacpp.presets.opencv_calib3d {
    static { Loader.load(); }

/* Wrapper for header file /usr/local/include/opencv2/calib3d/calib3d.hpp */

/*M///////////////////////////////////////////////////////////////////////////////////////
//
//  IMPORTANT: READ BEFORE DOWNLOADING, COPYING, INSTALLING OR USING.
//
//  By downloading, copying, installing or using the software you agree to this license.
//  If you do not agree to this license, do not download, install,
//  copy or use the software.
//
//
//                           License Agreement
//                For Open Source Computer Vision Library
//
// Copyright (C) 2000-2008, Intel Corporation, all rights reserved.
// Copyright (C) 2009, Willow Garage Inc., all rights reserved.
// Third party copyrights are property of their respective owners.
//
// Redistribution and use in source and binary forms, with or without modification,
// are permitted provided that the following conditions are met:
//
//   * Redistribution's of source code must retain the above copyright notice,
//     this list of conditions and the following disclaimer.
//
//   * Redistribution's in binary form must reproduce the above copyright notice,
//     this list of conditions and the following disclaimer in the documentation
//     and/or other materials provided with the distribution.
//
//   * The name of the copyright holders may not be used to endorse or promote products
//     derived from this software without specific prior written permission.
//
// This software is provided by the copyright holders and contributors "as is" and
// any express or implied warranties, including, but not limited to, the implied
// warranties of merchantability and fitness for a particular purpose are disclaimed.
// In no event shall the Intel Corporation or contributors be liable for any direct,
// indirect, incidental, special, exemplary, or consequential damages
// (including, but not limited to, procurement of substitute goods or services;
// loss of use, data, or profits; or business interruption) however caused
// and on any theory of liability, whether in contract, strict liability,
// or tort (including negligence or otherwise) arising in any way out of
// the use of this software, even if advised of the possibility of such damage.
//
//M*/

// #ifndef __OPENCV_CALIB3D_HPP__
// #define __OPENCV_CALIB3D_HPP__

// #include "opencv2/core/core.hpp"
// #include "opencv2/features2d/features2d.hpp"

// #ifdef __cplusplus
// #endif

/****************************************************************************************\
*                      Camera Calibration, Pose Estimation and Stereo                    *
\****************************************************************************************/

@Opaque public static class CvPOSITObject extends Pointer {
    public CvPOSITObject() { }
    public CvPOSITObject(Pointer p) { super(p); }
}

/* Allocates and initializes CvPOSITObject structure before doing cvPOSIT */
public static native CvPOSITObject cvCreatePOSITObject( CvPoint3D32f points, int point_count );


/* Runs POSIT (POSe from ITeration) algorithm for determining 3d position of
   an object given its model and projection in a weak-perspective case */
public static native void cvPOSIT(  CvPOSITObject posit_object, CvPoint2D32f image_points,
                       double focal_length, @ByVal CvTermCriteria criteria,
                       FloatPointer rotation_matrix, FloatPointer translation_vector);
public static native void cvPOSIT(  CvPOSITObject posit_object, CvPoint2D32f image_points,
                       double focal_length, @ByVal CvTermCriteria criteria,
                       FloatBuffer rotation_matrix, FloatBuffer translation_vector);
public static native void cvPOSIT(  CvPOSITObject posit_object, CvPoint2D32f image_points,
                       double focal_length, @ByVal CvTermCriteria criteria,
                       float[] rotation_matrix, float[] translation_vector);

/* Releases CvPOSITObject structure */
public static native void cvReleasePOSITObject( @Cast("CvPOSITObject**") PointerPointer posit_object );
public static native void cvReleasePOSITObject( @ByPtrPtr CvPOSITObject posit_object );

/* updates the number of RANSAC iterations */
public static native int cvRANSACUpdateNumIters( double p, double err_prob,
                                   int model_points, int max_iters );

public static native void cvConvertPointsHomogeneous( @Const CvMat src, CvMat dst );

/* Calculates fundamental matrix given a set of corresponding points */
public static final int CV_FM_7POINT = 1;
public static final int CV_FM_8POINT = 2;

public static final int CV_LMEDS = 4;
public static final int CV_RANSAC = 8;

public static final int CV_FM_LMEDS_ONLY =  CV_LMEDS;
public static final int CV_FM_RANSAC_ONLY = CV_RANSAC;
public static final int CV_FM_LMEDS = CV_LMEDS;
public static final int CV_FM_RANSAC = CV_RANSAC;

/** enum  */
public static final int
    CV_ITERATIVE = 0,
    CV_EPNP = 1, // F.Moreno-Noguer, V.Lepetit and P.Fua "EPnP: Efficient Perspective-n-Point Camera Pose Estimation"
    CV_P3P = 2; // X.S. Gao, X.-R. Hou, J. Tang, H.-F. Chang; "Complete Solution Classification for the Perspective-Three-Point Problem"

public static native int cvFindFundamentalMat( @Const CvMat points1, @Const CvMat points2,
                                 CvMat fundamental_matrix,
                                 int method/*CV_DEFAULT(CV_FM_RANSAC)*/,
                                 double param1/*CV_DEFAULT(3.)*/, double param2/*CV_DEFAULT(0.99)*/,
                                 CvMat status/*CV_DEFAULT(NULL)*/ );

/* For each input point on one of images
   computes parameters of the corresponding
   epipolar line on the other image */
public static native void cvComputeCorrespondEpilines( @Const CvMat points,
                                         int which_image,
                                         @Const CvMat fundamental_matrix,
                                         CvMat correspondent_lines );

/* Triangulation functions */

public static native void cvTriangulatePoints(CvMat projMatr1, CvMat projMatr2,
                                CvMat projPoints1, CvMat projPoints2,
                                CvMat points4D);

public static native void cvCorrectMatches(CvMat F, CvMat points1, CvMat points2,
                             CvMat new_points1, CvMat new_points2);


/* Computes the optimal new camera matrix according to the free scaling parameter alpha:
   alpha=0 - only valid pixels will be retained in the undistorted image
   alpha=1 - all the source image pixels will be retained in the undistorted image
*/
public static native void cvGetOptimalNewCameraMatrix( @Const CvMat camera_matrix,
                                         @Const CvMat dist_coeffs,
                                         @ByVal CvSize image_size, double alpha,
                                         CvMat new_camera_matrix,
                                         @ByVal CvSize new_imag_size/*CV_DEFAULT(cvSize(0,0))*/,
                                         CvRect valid_pixel_ROI/*CV_DEFAULT(0)*/,
                                         int center_principal_point/*CV_DEFAULT(0)*/);

/* Converts rotation vector to rotation matrix or vice versa */
public static native int cvRodrigues2( @Const CvMat src, CvMat dst,
                         CvMat jacobian/*CV_DEFAULT(0)*/ );

/* Finds perspective transformation between the object plane and image (view) plane */
public static native int cvFindHomography( @Const CvMat src_points,
                             @Const CvMat dst_points,
                             CvMat homography,
                             int method/*CV_DEFAULT(0)*/,
                             double ransacReprojThreshold/*CV_DEFAULT(3)*/,
                             CvMat mask/*CV_DEFAULT(0)*/);

/* Computes RQ decomposition for 3x3 matrices */
public static native void cvRQDecomp3x3( @Const CvMat matrixM, CvMat matrixR, CvMat matrixQ,
                           CvMat matrixQx/*CV_DEFAULT(NULL)*/,
                           CvMat matrixQy/*CV_DEFAULT(NULL)*/,
                           CvMat matrixQz/*CV_DEFAULT(NULL)*/,
                           CvPoint3D64f eulerAngles/*CV_DEFAULT(NULL)*/);

/* Computes projection matrix decomposition */
public static native void cvDecomposeProjectionMatrix( @Const CvMat projMatr, CvMat calibMatr,
                                         CvMat rotMatr, CvMat posVect,
                                         CvMat rotMatrX/*CV_DEFAULT(NULL)*/,
                                         CvMat rotMatrY/*CV_DEFAULT(NULL)*/,
                                         CvMat rotMatrZ/*CV_DEFAULT(NULL)*/,
                                         CvPoint3D64f eulerAngles/*CV_DEFAULT(NULL)*/);

/* Computes d(AB)/dA and d(AB)/dB */
public static native void cvCalcMatMulDeriv( @Const CvMat A, @Const CvMat B, CvMat dABdA, CvMat dABdB );

/* Computes r3 = rodrigues(rodrigues(r2)*rodrigues(r1)),
   t3 = rodrigues(r2)*t1 + t2 and the respective derivatives */
public static native void cvComposeRT( @Const CvMat _rvec1, @Const CvMat _tvec1,
                         @Const CvMat _rvec2, @Const CvMat _tvec2,
                         CvMat _rvec3, CvMat _tvec3,
                         CvMat dr3dr1/*CV_DEFAULT(0)*/, CvMat dr3dt1/*CV_DEFAULT(0)*/,
                         CvMat dr3dr2/*CV_DEFAULT(0)*/, CvMat dr3dt2/*CV_DEFAULT(0)*/,
                         CvMat dt3dr1/*CV_DEFAULT(0)*/, CvMat dt3dt1/*CV_DEFAULT(0)*/,
                         CvMat dt3dr2/*CV_DEFAULT(0)*/, CvMat dt3dt2/*CV_DEFAULT(0)*/ );

/* Projects object points to the view plane using
   the specified extrinsic and intrinsic camera parameters */
public static native void cvProjectPoints2( @Const CvMat object_points, @Const CvMat rotation_vector,
                              @Const CvMat translation_vector, @Const CvMat camera_matrix,
                              @Const CvMat distortion_coeffs, CvMat image_points,
                              CvMat dpdrot/*CV_DEFAULT(NULL)*/, CvMat dpdt/*CV_DEFAULT(NULL)*/,
                              CvMat dpdf/*CV_DEFAULT(NULL)*/, CvMat dpdc/*CV_DEFAULT(NULL)*/,
                              CvMat dpddist/*CV_DEFAULT(NULL)*/,
                              double aspect_ratio/*CV_DEFAULT(0)*/);

/* Finds extrinsic camera parameters from
   a few known corresponding point pairs and intrinsic parameters */
public static native void cvFindExtrinsicCameraParams2( @Const CvMat object_points,
                                          @Const CvMat image_points,
                                          @Const CvMat camera_matrix,
                                          @Const CvMat distortion_coeffs,
                                          CvMat rotation_vector,
                                          CvMat translation_vector,
                                          int use_extrinsic_guess/*CV_DEFAULT(0)*/ );

/* Computes initial estimate of the intrinsic camera parameters
   in case of planar calibration target (e.g. chessboard) */
public static native void cvInitIntrinsicParams2D( @Const CvMat object_points,
                                     @Const CvMat image_points,
                                     @Const CvMat npoints, @ByVal CvSize image_size,
                                     CvMat camera_matrix,
                                     double aspect_ratio/*CV_DEFAULT(1.)*/ );

public static final int CV_CALIB_CB_ADAPTIVE_THRESH =  1;
public static final int CV_CALIB_CB_NORMALIZE_IMAGE =  2;
public static final int CV_CALIB_CB_FILTER_QUADS =     4;
public static final int CV_CALIB_CB_FAST_CHECK =       8;

// Performs a fast check if a chessboard is in the input image. This is a workaround to
// a problem of cvFindChessboardCorners being slow on images with no chessboard
// - src: input image
// - size: chessboard size
// Returns 1 if a chessboard can be in this image and findChessboardCorners should be called,
// 0 if there is no chessboard, -1 in case of error
public static native int cvCheckChessboard(IplImage src, @ByVal CvSize size);

    /* Detects corners on a chessboard calibration pattern */
public static native int cvFindChessboardCorners( @Const Pointer image, @ByVal CvSize pattern_size,
                                    CvPoint2D32f corners,
                                    IntPointer corner_count/*CV_DEFAULT(NULL)*/,
                                    int flags/*CV_DEFAULT(CV_CALIB_CB_ADAPTIVE_THRESH+CV_CALIB_CB_NORMALIZE_IMAGE)*/ );
public static native int cvFindChessboardCorners( @Const Pointer image, @ByVal CvSize pattern_size,
                                    CvPoint2D32f corners,
                                    IntBuffer corner_count/*CV_DEFAULT(NULL)*/,
                                    int flags/*CV_DEFAULT(CV_CALIB_CB_ADAPTIVE_THRESH+CV_CALIB_CB_NORMALIZE_IMAGE)*/ );
public static native int cvFindChessboardCorners( @Const Pointer image, @ByVal CvSize pattern_size,
                                    CvPoint2D32f corners,
                                    int[] corner_count/*CV_DEFAULT(NULL)*/,
                                    int flags/*CV_DEFAULT(CV_CALIB_CB_ADAPTIVE_THRESH+CV_CALIB_CB_NORMALIZE_IMAGE)*/ );

/* Draws individual chessboard corners or the whole chessboard detected */
public static native void cvDrawChessboardCorners( CvArr image, @ByVal CvSize pattern_size,
                                     CvPoint2D32f corners,
                                     int count, int pattern_was_found );

public static final int CV_CALIB_USE_INTRINSIC_GUESS =  1;
public static final int CV_CALIB_FIX_ASPECT_RATIO =     2;
public static final int CV_CALIB_FIX_PRINCIPAL_POINT =  4;
public static final int CV_CALIB_ZERO_TANGENT_DIST =    8;
public static final int CV_CALIB_FIX_FOCAL_LENGTH = 16;
public static final int CV_CALIB_FIX_K1 =  32;
public static final int CV_CALIB_FIX_K2 =  64;
public static final int CV_CALIB_FIX_K3 =  128;
public static final int CV_CALIB_FIX_K4 =  2048;
public static final int CV_CALIB_FIX_K5 =  4096;
public static final int CV_CALIB_FIX_K6 =  8192;
public static final int CV_CALIB_RATIONAL_MODEL = 16384;

/* Finds intrinsic and extrinsic camera parameters
   from a few views of known calibration pattern */
public static native double cvCalibrateCamera2( @Const CvMat object_points,
                                @Const CvMat image_points,
                                @Const CvMat point_counts,
                                @ByVal CvSize image_size,
                                CvMat camera_matrix,
                                CvMat distortion_coeffs,
                                CvMat rotation_vectors/*CV_DEFAULT(NULL)*/,
                                CvMat translation_vectors/*CV_DEFAULT(NULL)*/,
                                int flags/*CV_DEFAULT(0)*/,
                                @ByVal CvTermCriteria term_crit/*CV_DEFAULT(cvTermCriteria(
                                    CV_TERMCRIT_ITER+CV_TERMCRIT_EPS,30,DBL_EPSILON))*/ );

/* Computes various useful characteristics of the camera from the data computed by
   cvCalibrateCamera2 */
public static native void cvCalibrationMatrixValues( @Const CvMat camera_matrix,
                                @ByVal CvSize image_size,
                                double aperture_width/*CV_DEFAULT(0)*/,
                                double aperture_height/*CV_DEFAULT(0)*/,
                                DoublePointer fovx/*CV_DEFAULT(NULL)*/,
                                DoublePointer fovy/*CV_DEFAULT(NULL)*/,
                                DoublePointer focal_length/*CV_DEFAULT(NULL)*/,
                                CvPoint2D64f principal_point/*CV_DEFAULT(NULL)*/,
                                DoublePointer pixel_aspect_ratio/*CV_DEFAULT(NULL)*/);
public static native void cvCalibrationMatrixValues( @Const CvMat camera_matrix,
                                @ByVal CvSize image_size,
                                double aperture_width/*CV_DEFAULT(0)*/,
                                double aperture_height/*CV_DEFAULT(0)*/,
                                DoubleBuffer fovx/*CV_DEFAULT(NULL)*/,
                                DoubleBuffer fovy/*CV_DEFAULT(NULL)*/,
                                DoubleBuffer focal_length/*CV_DEFAULT(NULL)*/,
                                CvPoint2D64f principal_point/*CV_DEFAULT(NULL)*/,
                                DoubleBuffer pixel_aspect_ratio/*CV_DEFAULT(NULL)*/);
public static native void cvCalibrationMatrixValues( @Const CvMat camera_matrix,
                                @ByVal CvSize image_size,
                                double aperture_width/*CV_DEFAULT(0)*/,
                                double aperture_height/*CV_DEFAULT(0)*/,
                                double[] fovx/*CV_DEFAULT(NULL)*/,
                                double[] fovy/*CV_DEFAULT(NULL)*/,
                                double[] focal_length/*CV_DEFAULT(NULL)*/,
                                CvPoint2D64f principal_point/*CV_DEFAULT(NULL)*/,
                                double[] pixel_aspect_ratio/*CV_DEFAULT(NULL)*/);

public static final int CV_CALIB_FIX_INTRINSIC =  256;
public static final int CV_CALIB_SAME_FOCAL_LENGTH = 512;

/* Computes the transformation from one camera coordinate system to another one
   from a few correspondent views of the same calibration target. Optionally, calibrates
   both cameras */
public static native double cvStereoCalibrate( @Const CvMat object_points, @Const CvMat image_points1,
                               @Const CvMat image_points2, @Const CvMat npoints,
                               CvMat camera_matrix1, CvMat dist_coeffs1,
                               CvMat camera_matrix2, CvMat dist_coeffs2,
                               @ByVal CvSize image_size, CvMat R, CvMat T,
                               CvMat E/*CV_DEFAULT(0)*/, CvMat F/*CV_DEFAULT(0)*/,
                               @ByVal CvTermCriteria term_crit/*CV_DEFAULT(cvTermCriteria(
                                   CV_TERMCRIT_ITER+CV_TERMCRIT_EPS,30,1e-6))*/,
                               int flags/*CV_DEFAULT(CV_CALIB_FIX_INTRINSIC)*/);

public static final int CV_CALIB_ZERO_DISPARITY = 1024;

/* Computes 3D rotations (+ optional shift) for each camera coordinate system to make both
   views parallel (=> to make all the epipolar lines horizontal or vertical) */
public static native void cvStereoRectify( @Const CvMat camera_matrix1, @Const CvMat camera_matrix2,
                             @Const CvMat dist_coeffs1, @Const CvMat dist_coeffs2,
                             @ByVal CvSize image_size, @Const CvMat R, @Const CvMat T,
                             CvMat R1, CvMat R2, CvMat P1, CvMat P2,
                             CvMat Q/*CV_DEFAULT(0)*/,
                             int flags/*CV_DEFAULT(CV_CALIB_ZERO_DISPARITY)*/,
                             double alpha/*CV_DEFAULT(-1)*/,
                             @ByVal CvSize new_image_size/*CV_DEFAULT(cvSize(0,0))*/,
                             CvRect valid_pix_ROI1/*CV_DEFAULT(0)*/,
                             CvRect valid_pix_ROI2/*CV_DEFAULT(0)*/);

/* Computes rectification transformations for uncalibrated pair of images using a set
   of point correspondences */
public static native int cvStereoRectifyUncalibrated( @Const CvMat points1, @Const CvMat points2,
                                        @Const CvMat F, @ByVal CvSize img_size,
                                        CvMat H1, CvMat H2,
                                        double threshold/*CV_DEFAULT(5)*/);



/* stereo correspondence parameters and functions */

public static final int CV_STEREO_BM_NORMALIZED_RESPONSE =  0;
public static final int CV_STEREO_BM_XSOBEL =               1;

/* Block matching algorithm structure */
public static class CvStereoBMState extends Pointer {
    static { Loader.load(); }
    public CvStereoBMState() { allocate(); }
    public CvStereoBMState(int size) { allocateArray(size); }
    public CvStereoBMState(Pointer p) { super(p); }
    private native void allocate();
    private native void allocateArray(int size);
    @Override public CvStereoBMState position(int position) {
        return (CvStereoBMState)super.position(position);
    }

    // pre-filtering (normalization of input images)
    public native int preFilterType(); public native CvStereoBMState preFilterType(int preFilterType); // =CV_STEREO_BM_NORMALIZED_RESPONSE now
    public native int preFilterSize(); public native CvStereoBMState preFilterSize(int preFilterSize); // averaging window size: ~5x5..21x21
    public native int preFilterCap(); public native CvStereoBMState preFilterCap(int preFilterCap); // the output of pre-filtering is clipped by [-preFilterCap,preFilterCap]

    // correspondence using Sum of Absolute Difference (SAD)
    public native int SADWindowSize(); public native CvStereoBMState SADWindowSize(int SADWindowSize); // ~5x5..21x21
    public native int minDisparity(); public native CvStereoBMState minDisparity(int minDisparity);  // minimum disparity (can be negative)
    public native int numberOfDisparities(); public native CvStereoBMState numberOfDisparities(int numberOfDisparities); // maximum disparity - minimum disparity (> 0)

    // post-filtering
    public native int textureThreshold(); public native CvStereoBMState textureThreshold(int textureThreshold);  // the disparity is only computed for pixels
                           // with textured enough neighborhood
    public native int uniquenessRatio(); public native CvStereoBMState uniquenessRatio(int uniquenessRatio);   // accept the computed disparity d* only if
                           // SAD(d) >= SAD(d*)*(1 + uniquenessRatio/100.)
                           // for any d != d*+/-1 within the search range.
    public native int speckleWindowSize(); public native CvStereoBMState speckleWindowSize(int speckleWindowSize); // disparity variation window
    public native int speckleRange(); public native CvStereoBMState speckleRange(int speckleRange); // acceptable range of variation in window

    public native int trySmallerWindows(); public native CvStereoBMState trySmallerWindows(int trySmallerWindows); // if 1, the results may be more accurate,
                           // at the expense of slower processing
    public native @ByVal CvRect roi1(); public native CvStereoBMState roi1(CvRect roi1);
    public native @ByVal CvRect roi2(); public native CvStereoBMState roi2(CvRect roi2);
    public native int disp12MaxDiff(); public native CvStereoBMState disp12MaxDiff(int disp12MaxDiff);

    // temporary buffers
    public native CvMat preFilteredImg0(); public native CvStereoBMState preFilteredImg0(CvMat preFilteredImg0);
    public native CvMat preFilteredImg1(); public native CvStereoBMState preFilteredImg1(CvMat preFilteredImg1);
    public native CvMat slidingSumBuf(); public native CvStereoBMState slidingSumBuf(CvMat slidingSumBuf);
    public native CvMat cost(); public native CvStereoBMState cost(CvMat cost);
    public native CvMat disp(); public native CvStereoBMState disp(CvMat disp);
}

public static final int CV_STEREO_BM_BASIC = 0;
public static final int CV_STEREO_BM_FISH_EYE = 1;
public static final int CV_STEREO_BM_NARROW = 2;

public static native CvStereoBMState cvCreateStereoBMState(int preset/*CV_DEFAULT(CV_STEREO_BM_BASIC)*/,
                                              int numberOfDisparities/*CV_DEFAULT(0)*/);

public static native void cvReleaseStereoBMState( @Cast("CvStereoBMState**") PointerPointer state );
public static native void cvReleaseStereoBMState( @ByPtrPtr CvStereoBMState state );

public static native void cvFindStereoCorrespondenceBM( @Const CvArr left, @Const CvArr right,
                                          CvArr disparity, CvStereoBMState state );

public static native @ByVal CvRect cvGetValidDisparityROI( @ByVal CvRect roi1, @ByVal CvRect roi2, int minDisparity,
                                      int numberOfDisparities, int SADWindowSize );

public static native void cvValidateDisparity( CvArr disparity, @Const CvArr cost,
                                 int minDisparity, int numberOfDisparities,
                                 int disp12MaxDiff/*CV_DEFAULT(1)*/ );

/* Reprojects the computed disparity image to the 3D space using the specified 4x4 matrix */
public static native void cvReprojectImageTo3D( @Const CvArr disparityImage,
                                   CvArr _3dImage, @Const CvMat Q,
                                   int handleMissingValues/*CV_DEFAULT(0)*/ );


// #ifdef __cplusplus

// #endif

// #endif


}
