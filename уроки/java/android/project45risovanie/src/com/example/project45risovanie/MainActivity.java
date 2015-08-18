package com.example.project45risovanie;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(new DrawView(this));
	}

	class DrawView extends View {

		Paint p;
		RectF rectf;
		float[] points;
		float[] points1;

		public DrawView(Context context) {
			super(context);
			p = new Paint();
			rectf = new RectF(700, 100, 800, 150);
			points = new float[] { 100, 50, 150, 100, 150, 200, 50, 200, 50,
					100 };
			points1 = new float[] { 300, 200, 600, 200, 300, 300, 600, 300,
					400, 100, 400, 400, 500, 100, 500, 400 };
		}

		@Override
		protected void onDraw(Canvas canvas) {
			canvas.drawARGB(80, 102, 204, 255);

			p.setColor(Color.RED);
			p.setStrokeWidth(10);

			// ������ ����� �� ������� points
			canvas.drawPoints(points, p);

			// ������ ����� �� ������ �� ������� points1
			canvas.drawLines(points1, p);

			// ��������������� ����� �� ������� ����
			p.setColor(Color.GREEN);

			// ������ ������������ ������������� �� ����������� �� rectf
			// ������� ����������� = 20
			canvas.drawRoundRect(rectf, 20, 20, p);

			// ������� ��������� rectf �� 150 ����
			rectf.offset(0, 150);
			// ������ ���� ������ �������������� rectf
			canvas.drawOval(rectf, p);

			// ������� rectf � (900,100) (����� ������� �����)
			rectf.offsetTo(900, 100);
			// ����������� rectf �� ��������� �� 25 ���� � �����
			rectf.inset(0, -25);
			// ������ ���� ������ �������������� rectf
			// � ������� � 90, � ������ 270
			// ���������� ������� ����� ����� �����
			canvas.drawArc(rectf, 90, 270, true, p);

			// ������� ��������� rectf �� 150 ����
			rectf.offset(0, 150);
			// ������ ���� ������ �������������� rectf
			// � ������� � 90, � ������ 270
			// ���������� ������� ����� ��������
			canvas.drawArc(rectf, 90, 270, false, p);

			// ��������������� ����� �� ������� ����� = 3
			p.setStrokeWidth(3);
			// ������ ����� (150,450) - (150,600)
			canvas.drawLine(150, 450, 150, 600, p);

			// ��������������� ����� �� ����� ����
			p.setColor(Color.BLUE);

			// ����������� ������ ������ = 30
			p.setTextSize(30);
			// ������ ����� � ����� (150,500)
			canvas.drawText("text left", 150, 500, p);

			// ����������� ������������ ������ �� �����
			p.setTextAlign(Paint.Align.CENTER);
			// ������ ����� � ����� (150,525)
			canvas.drawText("text center", 150, 525, p);

			// ����������� ������������ ������ �� �����
			p.setTextAlign(Paint.Align.RIGHT);
			// ������ ����� � ����� (150,550)
			canvas.drawText("text right", 150, 550, p);
		}
	}
}
