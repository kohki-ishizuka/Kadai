package begineer4;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class CountUpButton {
	static int count = 0;

	public static void main(String[] args) {

		JFrame frame = new JFrame();

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(300, 350); // ウィンドウのサイズを設定

		//レイアウトを設定
		frame.setLayout(new FlowLayout());

		//ボタンの作成
		JButton button1 = new JButton("カウントアップ");
		JButton button2 = new JButton("リセット");
	
		//カウンターの作成
		JLabel countLabel = new JLabel(count + "回");
		frame.add(countLabel);
		countLabel.setPreferredSize(new Dimension(200, 200));
		countLabel.setHorizontalAlignment(JLabel.CENTER);
		countLabel.setVerticalAlignment(JLabel.CENTER);

		//ボタン押下時の動作を設定(カウントアップ)
		button1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				count++;
				String UpCount = String.valueOf(count);
				countLabel.setText(UpCount + "回");
			}
		});

		//ボタン押下時の動作を設定(リセット)
		button2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				count = 0;
				String resetCount = String.valueOf(count);
				countLabel.setText(resetCount + "回");
			}
		});

		//ボタンをウィンドウに追加
		frame.add(button1);
		frame.add(button2);

		frame.setVisible(true); // ウィンドウを表示
	}
}