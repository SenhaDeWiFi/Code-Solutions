package windowPrograms;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Dimension;

import javax.swing.ButtonGroup;
import javax.swing.JTextArea;
import javax.swing.UIManager;

public class Window extends JFrame implements ActionListener{

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Window frame = new Window();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	JRadioButton ex1Button;
	JRadioButton ex2Button;
	JRadioButton ex3Button;
	JRadioButton ex4Button;
	JRadioButton ex5Button;
	JButton actionBtn;
	int exNum;

	/**
	 * Create the frame.
	 */
	public Window() {

		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 489, 460);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		JPanel exPanel = new JPanel();
		exPanel.setBounds(6, 46, 460, 375);
		exPanel.setLayout(null);
		
		JTextArea inputTextArea = new JTextArea();
		inputTextArea.setLineWrap(true);
		inputTextArea.setRows(255);
		inputTextArea.setWrapStyleWord(true);
		inputTextArea.setBounds(10, 45, 196, 272);
		exPanel.add(inputTextArea);
		
		JTextArea outputTextArea = new JTextArea();
		outputTextArea.setText("Selecione um dos exercícios no menu acima, digite algo e aperte o botão!");
		outputTextArea.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 14));
		outputTextArea.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		outputTextArea.setBackground(UIManager.getColor("Button.background"));
		outputTextArea.setEditable(false);
		outputTextArea.setWrapStyleWord(true);
		outputTextArea.setRows(255);
		outputTextArea.setLineWrap(true);
		outputTextArea.setBounds(254, 43, 196, 316);
		exPanel.add(outputTextArea);
		
		
		actionBtn = new JButton("Selecione um Ex");
		actionBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String userInput = inputTextArea.getText();
				String methodReturn = "";				
				switch (exNum) {
				case 1:
					methodReturn = ExerciseMethods.reveString(userInput);
					break;
					
				case 2:
					methodReturn = ExerciseMethods.removeDups(userInput);
					break;
					
				case 3:
					methodReturn = ExerciseMethods.longestPalindromeIn(userInput);
					break;
					
				case 4:
					methodReturn = ExerciseMethods.upperCaseFirst(userInput);
					break;
					
				case 5:
					methodReturn += ExerciseMethods.isPalinagram(userInput);
					break;
					
				default:
					break;
				
				}
				outputTextArea.setText(methodReturn);
				
			}
		});
		actionBtn.setFont(new Font("Verdana", Font.PLAIN, 14));
		actionBtn.setBounds(10, 326, 196, 42);
		exPanel.add(actionBtn);
		
		JLabel lblNewLabel = new JLabel("Input");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Verdana", Font.BOLD, 15));
		lblNewLabel.setBounds(10, 11, 196, 18);
		exPanel.add(lblNewLabel);
		
		JLabel lblOutput = new JLabel("Output");
		lblOutput.setHorizontalAlignment(SwingConstants.CENTER);
		lblOutput.setFont(new Font("Verdana", Font.BOLD, 15));
		lblOutput.setBounds(254, 11, 196, 18);
		exPanel.add(lblOutput);
		
		ex1Button = new JRadioButton("Ex1");
		ex1Button.setBounds(6, 3, 47, 36);
		ex1Button.setHorizontalAlignment(SwingConstants.CENTER);
		ex1Button.setPreferredSize(new Dimension(24, 23));
		ex1Button.setMinimumSize(new Dimension(25, 23));
		contentPane.setLayout(null);
		contentPane.add(exPanel);
		contentPane.add(ex1Button);
		
		ex2Button = new JRadioButton("Ex2");
		ex2Button.setPreferredSize(new Dimension(24, 23));
		ex2Button.setMinimumSize(new Dimension(25, 23));
		ex2Button.setHorizontalAlignment(SwingConstants.CENTER);
		ex2Button.setBounds(55, 3, 47, 36);
		contentPane.add(ex2Button);
		
		ex3Button = new JRadioButton("Ex3");
		ex3Button.setPreferredSize(new Dimension(24, 23));
		ex3Button.setMinimumSize(new Dimension(25, 23));
		ex3Button.setHorizontalAlignment(SwingConstants.CENTER);
		ex3Button.setBounds(104, 3, 47, 36);
		contentPane.add(ex3Button);
		
		ex4Button = new JRadioButton("Ex4");
		ex4Button.setPreferredSize(new Dimension(24, 23));
		ex4Button.setMinimumSize(new Dimension(25, 23));
		ex4Button.setHorizontalAlignment(SwingConstants.CENTER);
		ex4Button.setBounds(151, 3, 47, 36);
		contentPane.add(ex4Button);
		
		ex5Button = new JRadioButton("Ex5");
		ex5Button.setPreferredSize(new Dimension(24, 23));
		ex5Button.setMinimumSize(new Dimension(25, 23));
		ex5Button.setHorizontalAlignment(SwingConstants.CENTER);
		ex5Button.setBounds(200, 3, 47, 36);
		contentPane.add(ex5Button);
		
		ButtonGroup group = new ButtonGroup();
		group.add(ex1Button);
		group.add(ex2Button);
		group.add(ex3Button);
		group.add(ex4Button);
		group.add(ex5Button);
		
		ex1Button.addActionListener(this);
		ex2Button.addActionListener(this);
		ex3Button.addActionListener(this);
		ex4Button.addActionListener(this);
		ex5Button.addActionListener(this);
		
		
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == ex1Button){
			exNum = 1;
			actionBtn.setText("Inverter");
		}else if (e.getSource() == ex2Button){
			exNum = 2;
			actionBtn.setText("Remover duplicados");
		}else if (e.getSource() == ex3Button){
			exNum = 3;
			actionBtn.setText("Maior Palindromo");
		}else if (e.getSource() == ex4Button){
			exNum = 4;
			actionBtn.setText("Caps na primeira");
		}else if (e.getSource() == ex5Button){
			exNum = 5;
			actionBtn.setText("Palinagrama");
		}
	}
}
