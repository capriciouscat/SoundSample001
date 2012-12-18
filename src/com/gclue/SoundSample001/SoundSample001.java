package com.gclue.SoundSample001;

import java.io.IOException;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;

public class SoundSample001 extends Activity {

	@Override
	public void onCreate( Bundle savedInstanceState ) {
		super.onCreate( savedInstanceState );
		// �`��N���X�̃C���X�^���X�𐶐�
		MyView mView = new MyView( this );
		// ���݂�View�ɐݒ�
		setContentView( mView );
	}
}

/**
 * �`��p�̃N���X
 */
class MyView extends View {
	/** �T�E���h�Đ��f�[�^��ێ�����B */
	private MediaPlayer mp;

	/**
	 * �R���X�g���N�^�B
	 * @param context �R���e�L�X�g
	 */
	public MyView( Context context ) {
		super( context );

		// �C�x���g���擾�ł���悤��Focus��L���ɂ���
		setFocusable( true );

		// �T�E���h�f�[�^��ǂݍ��ށi/res/raw/pon.mp3�j
		mp = MediaPlayer.create( context, R.raw.pon );
	}

	/**
	 * �`�揈���B
	 */
	@Override
	protected void onDraw( Canvas canvas ) {
		// �w�i�F��ݒ肷��
		canvas.drawColor( Color.BLUE );
	}

	/**
	 * �^�b�`�C�x���g�B
	 */
	@Override
	public boolean onTouchEvent( MotionEvent event ) {
		if ( event.getAction() == MotionEvent.ACTION_DOWN ) {
			// ACTION_DOWN�͎w���G�ꂽ��
			// ���̍Đ��J�n�ʒu��0�~���Z�J���h�̈ʒu�ɐݒ肷��
			mp.seekTo( 0 );
			// ���̍Đ����J�n����
			mp.start();
		} else if ( event.getAction() == MotionEvent.ACTION_UP ) {
			// ACTION_UP�͎w�����ꂽ��
			// �����~����
			mp.stop();

			// ��x�Đ���stop()���Ă���Ăщ����Đ�����ꍇ�́Aprepare()���Ăяo���K�v������
			try {
				mp.prepare();
			} catch ( IllegalStateException e ) {
				e.printStackTrace();
			} catch ( IOException e ) {
				e.printStackTrace();
			}
		}
		return true;
	}
}