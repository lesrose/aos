package cn.aos.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import sun.audio.AudioPlayer;

public class Music {

	private InputStream inputStream = null;

	private String file = "E:\\JAVA\\project\\aos0.2\\WebContent\\music\\music.wav";

	public void play() throws IOException {

		inputStream = new FileInputStream(new File(file));

		AudioPlayer.player.start(inputStream);
	}
}
