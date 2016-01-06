package javaPlusJS;

import java.io.*;
import java.awt.event.*;

import javax.script.*;
import javax.swing.*;

public class Keys {

	public static void main(String[] args) throws ScriptException, IOException{
		ScriptEngineManager sem = new ScriptEngineManager();
		ScriptEngine js = sem.getEngineByExtension("js");
		
		js.eval(new FileReader("listener.js"));
		
		Invocable invocable = (Invocable)js;
		KeyListener listener = invocable.getInterface(KeyListener.class);
		JFrame frame = new JFrame("Keys Demo");
		frame.addKeyListener(listener);
		frame.setSize(200, 200);
		frame.setVisible(true);
	}

}
