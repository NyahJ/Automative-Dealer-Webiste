import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

public class FilterWindow {

	private JFrame frame;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FilterWindow window = new FilterWindow();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public FilterWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1325, 788);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(320, 106, 542, 61);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Search");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(920, 120, 102, 33);
		frame.getContentPane().add(btnNewButton);
		
		JLabel FilterByLabel = new JLabel("Filter By");
		FilterByLabel.setFont(new Font("Tahoma", Font.PLAIN, 23));
		FilterByLabel.setBounds(10, 262, 139, 33);
		frame.getContentPane().add(FilterByLabel);
		
		JComboBox brand = new JComboBox(new String[]{"0-2000", "2000-3000", "3000-5000", "5000+"});
		brand.setEditable(true);
		brand.setBounds(500, 269, 29, 21);
		frame.getContentPane().add(brand);
		
		JLabel brandLabel = new JLabel("Brand");
		brand.setFont(new Font("Tahoma", Font.PLAIN, 20));
		brand.setBounds(234, 273, 81, 21);
		frame.getContentPane().add(brandLabel);
		
		JLabel modelLabel = new JLabel("Model");
		modelLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		modelLabel.setBounds(359, 274, 72, 21);
		frame.getContentPane().add(modelLabel);
		
		JComboBox model = new JComboBox();
		model.setBounds(325, 273, 29, 21);
		frame.getContentPane().add(model);
		
		JComboBox type = new JComboBox();
		type.setBounds(441, 274, 29, 21);
		frame.getContentPane().add(type);
		
		JLabel typelabel = new JLabel("Type");
		typelabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		typelabel.setBounds(480, 274, 81, 21);
		frame.getContentPane().add(typelabel);
		
		JComboBox category = new JComboBox();
		category.setBounds(558, 273, 29, 21);
		frame.getContentPane().add(category);
		
		JLabel categoryLabel = new JLabel("Category");
		categoryLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		categoryLabel.setBounds(587, 267, 109, 33);
		frame.getContentPane().add(categoryLabel);
		
		JComboBox color = new JComboBox();
		color.setBounds(695, 273, 29, 21);
		frame.getContentPane().add(color);
		
		JLabel colorLabel = new JLabel("Color");
		colorLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		colorLabel.setBounds(726, 274, 54, 21);
		frame.getContentPane().add(colorLabel);
		
		JComboBox price = new JComboBox();
		price.setBounds(794, 273, 29, 21);
		frame.getContentPane().add(price);
		
		JLabel priceLabel = new JLabel("Price");
		priceLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		priceLabel.setBounds(827, 273, 72, 17);
		frame.getContentPane().add(priceLabel);
	}
}
