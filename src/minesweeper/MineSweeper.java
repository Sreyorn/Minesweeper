package minesweeper;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import javax.swing.*;

public class MineSweeper extends JFrame implements ActionListener {
	final static int EASY = 64;
	final static int MEDIUM = 225;
	final static int HARD = 900;
	private JMenuBar menuBar;
	private JMenu game, file, help;
	private JMenuItem start, level, exit, save, blog, about;
	private JButton[] buttons;
	JButton easyBtn,mediumBtn,hardBtn;
	Container pane = getContentPane();
    int selectedLevel=EASY;

	public MineSweeper() {
		setTitle("Minesweeper");
		setSize(300, 350);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		menuBar = new JMenuBar();

		pane.setLayout(null);
		setJMenuBar(menuBar);
		GameMenu();
		FileMenu();
		HelpMenu();
		int x, y;
		x = 20;
		y = 20;
		buttons = new JButton[selectedLevel];
//		Color bg=Color.green;
//		pane.setBackground(bg);
		ActionListener l = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				float r, g, b;
				r = (float) Math.random();
				g = (float) Math.random();
				b = (float) Math.random();
				Color bgg = new Color(r, g, b);
//				pane.setBackground(bgg);
				int rand = (int) (Math.random() * selectedLevel);
				for (int i = 0; i < selectedLevel; i++)
					buttons[rand].setBackground(bgg);
			}

		};
		for (int i = 0; i < selectedLevel; i++) {
			buttons[i] = new JButton("");
			buttons[i].setSize(30, 30);
			buttons[i].setLocation(x, y);
			buttons[i].addActionListener(l);
			pane.add(buttons[i], BorderLayout.CENTER);
			x = x + 30;
			if ((i + 1) % 8 == 0) {
				x = 20;
				y = y + 30;
			}
		}

	}
	public void actionPerformed(ActionEvent e) {
		JMenuItem item = (JMenuItem) e.getSource();
		if (item == exit)
			System.exit(0);
		else if (item == start) {
			for (int i = 0; i < selectedLevel; i++)
				buttons[i].setBackground(null);
		} else if (item == level) {
			for(int i=0;i<selectedLevel;i++) {
				pane.remove(buttons[i]);
			}
			easyBtn=new JButton("EASY LEVEL");
			mediumBtn=new JButton("MEDIUM LEVEL");
			hardBtn=new JButton("HARD LEVEL");
			easyBtn.setSize(150,50);
			mediumBtn.setSize(150,50);
			hardBtn.setSize(150,50);
			easyBtn.setLocation(100,70);
			mediumBtn.setLocation(100,150);
			hardBtn.setLocation(100,230);
			pane.add(easyBtn);
			pane.add(mediumBtn);
			pane.add(hardBtn);
		}
	}

	private void HelpMenu() {
		help = new JMenu("Help");
		menuBar.add(help);
		about = new JMenuItem("About");
		help.add(about);
	}

	private void GameMenu() {
		game = new JMenu("Game");
		menuBar.add(game);
		start = new JMenuItem("Start");
		level = new JMenuItem("Choose Level");
		exit = new JMenuItem("Exit");
		exit.addActionListener(this);
		game.add(start);
		start.addActionListener(this);
		game.add(level);
		level.addActionListener(this);
		game.add(exit);
	}

	private void FileMenu() {
		file = new JMenu("File");
		menuBar.add(file);
		save = new JMenuItem("Save");
		blog = new JMenuItem("Blog");
		file.add(save);
		file.add(blog);
	}

	public static void main(String[] args) {
		new MineSweeper();
	}
}
