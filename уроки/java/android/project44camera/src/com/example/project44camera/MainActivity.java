package com.example.project44camera;

import java.io.IOException;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.hardware.Camera;
import android.hardware.Camera.CameraInfo;
import android.hardware.Camera.Size;
import android.os.Bundle;
import android.view.Display;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.Window;
import android.view.WindowManager;

public class MainActivity extends Activity {

	SurfaceView sv;
	SurfaceHolder holder;
	HolderCallback holderCallback;
	@SuppressWarnings("deprecation")
	Camera camera;

	final int CAMERA_ID = 0;
	final boolean FULL_SCREEN = true;

	@SuppressWarnings("deprecation")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.activity_main);

		sv = (SurfaceView) findViewById(R.id.surfaceView);
		holder = sv.getHolder();
		holder.setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS);

		holderCallback = new HolderCallback();
		holder.addCallback(holderCallback);
	}

	@SuppressWarnings("deprecation")
	@Override
	protected void onResume() {
		super.onResume();
		camera = Camera.open(CAMERA_ID);
		setPreviewSize(FULL_SCREEN);
	}

	@SuppressWarnings("deprecation")
	@Override
	protected void onPause() {
		super.onPause();
		if (camera != null)
			camera.release();
		camera = null;
	}

	class HolderCallback implements SurfaceHolder.Callback {

		@SuppressWarnings("deprecation")
		@Override
		public void surfaceCreated(SurfaceHolder holder) {
			try {
				camera.setPreviewDisplay(holder);
				camera.startPreview();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		@SuppressWarnings("deprecation")
		@Override
		public void surfaceChanged(SurfaceHolder holder, int format, int width,
				int height) {
			camera.stopPreview();
			setCameraDisplayOrientation(CAMERA_ID);
			try {
				camera.setPreviewDisplay(holder);
				camera.startPreview();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		@Override
		public void surfaceDestroyed(SurfaceHolder holder) {

		}

	}

	@SuppressWarnings("deprecation")
	void setPreviewSize(boolean fullScreen) {

		// �������� ������� ������
		Display display = getWindowManager().getDefaultDisplay();
		@SuppressWarnings("deprecation")
		boolean widthIsMax = display.getWidth() > display.getHeight();

		// ���������� ������� ������ ������
		@SuppressWarnings("deprecation")
		Size size = camera.getParameters().getPreviewSize();

		RectF rectDisplay = new RectF();
		RectF rectPreview = new RectF();

		// RectF ������, ������������ �������� ������
		rectDisplay.set(0, 0, display.getWidth(), display.getHeight());

		// RectF ������
		if (widthIsMax) {
			// ������ � �������������� ����������
			rectPreview.set(0, 0, size.width, size.height);
		} else {
			// ������ � ������������ ����������
			rectPreview.set(0, 0, size.height, size.width);
		}

		Matrix matrix = new Matrix();
		// ���������� ������� ��������������
		if (!fullScreen) {
			// ���� ������ ����� "�������" � ����� (������ ������� �� �����)
			matrix.setRectToRect(rectPreview, rectDisplay,
					Matrix.ScaleToFit.START);
		} else {
			// ���� ����� ����� "�������" � ������ (������ ������� �� �����)
			matrix.setRectToRect(rectDisplay, rectPreview,
					Matrix.ScaleToFit.START);
			matrix.invert(matrix);
		}
		// ��������������
		matrix.mapRect(rectPreview);

		// ��������� �������� surface �� ������������� ��������������
		sv.getLayoutParams().height = (int) (rectPreview.bottom);
		sv.getLayoutParams().width = (int) (rectPreview.right);
	}

	@SuppressLint("NewApi")
	@SuppressWarnings("deprecation")
	void setCameraDisplayOrientation(int cameraId) {
		// ���������� ��������� �������� ����� �� ����������� ���������
		int rotation = getWindowManager().getDefaultDisplay().getRotation();
		int degrees = 0;
		switch (rotation) {
		case Surface.ROTATION_0:
			degrees = 0;
			break;
		case Surface.ROTATION_90:
			degrees = 90;
			break;
		case Surface.ROTATION_180:
			degrees = 180;
			break;
		case Surface.ROTATION_270:
			degrees = 270;
			break;
		}

		int result = 0;

		// �������� ���� �� ������ cameraId
		CameraInfo info = new CameraInfo();
		Camera.getCameraInfo(cameraId, info);

		// ������ ������
		if (info.facing == CameraInfo.CAMERA_FACING_BACK) {
			result = ((360 - degrees) + info.orientation);
		} else
		// �������� ������
		if (info.facing == CameraInfo.CAMERA_FACING_FRONT) {
			result = ((360 - degrees) - info.orientation);
			result += 360;
		}
		result = result % 360;
		camera.setDisplayOrientation(result);
	}
}