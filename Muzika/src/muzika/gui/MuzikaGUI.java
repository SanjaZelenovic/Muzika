package muzika.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import muzika.Muzika;
import net.miginfocom.swing.MigLayout;

import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import java.awt.Component;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;

import java.awt.Toolkit;
import java.util.LinkedList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class MuzikaGUI extends JFrame {

	private JPanel contentPane;
	private JPanel panel;
	private JPanel panel_1;
	private JPanel panel_2;
	private JLabel lblAutor;
	private JScrollPane scrollPane;
	private JTextArea textAreaString;
	private JScrollPane scrollPane_1;
	private JTextArea textAreaJSON;
	private JTextField textFieldAutor;
	private JLabel lblPesma;
	private JTextField textFieldPesma;
	private JLabel lblAlbum;
	private JTextField textFieldAlbum;
	private JLabel lblPozicijaNaMTVListi;
	private JTextField textFieldPozicijaNaMTVListi;
	private JButton btnNewButton;
	private LinkedList<Muzika> pesme = new LinkedList<Muzika>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MuzikaGUI frame = new MuzikaGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MuzikaGUI() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(MuzikaGUI.class.getResource("/com/sun/java/swing/plaf/windows/icons/Computer.gif")));
		setTitle("Muzika");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 459, 353);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[160.00,grow][156.00,grow][159.00,grow]", "[grow]"));
		contentPane.add(getPanel(), "cell 0 0,grow");
		contentPane.add(getPanel_1(), "cell 1 0,grow");
		contentPane.add(getPanel_2(), "cell 2 0,grow");
	}

	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setLayout(new BorderLayout(0, 0));
			panel.add(getScrollPane(), BorderLayout.CENTER);
		}
		return panel;
	}
	private JPanel getPanel_1() {
		if (panel_1 == null) {
			panel_1 = new JPanel();
			panel_1.setLayout(null);
			panel_1.add(getLblAutor());
			panel_1.add(getTextFieldAutor());
			panel_1.add(getLblPesma());
			panel_1.add(getTextFieldPesma());
			panel_1.add(getLblAlbum());
			panel_1.add(getTextFieldAlbum());
			panel_1.add(getLblPozicijaNaMTVListi());
			panel_1.add(getTextFieldPozicijaNaMTVListi());
			panel_1.add(getBtnNewButton());
		}
		return panel_1;
	}
	private JPanel getPanel_2() {
		if (panel_2 == null) {
			panel_2 = new JPanel();
			panel_2.setLayout(new BorderLayout(0, 0));
			panel_2.add(getScrollPane_1(), BorderLayout.CENTER);
		}
		return panel_2;
	}
	private JLabel getLblAutor() {
		if (lblAutor == null) {
			lblAutor = new JLabel("Autor");
			lblAutor.setAlignmentX(Component.CENTER_ALIGNMENT);
			lblAutor.setHorizontalAlignment(SwingConstants.CENTER);
			lblAutor.setBounds(32, 5, 70, 16);
		}
		return lblAutor;
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setViewportView(getTextAreaString());
		}
		return scrollPane;
	}
	private JTextArea getTextAreaString() {
		if (textAreaString == null) {
			textAreaString = new JTextArea();
		}
		return textAreaString;
	}
	private JScrollPane getScrollPane_1() {
		if (scrollPane_1 == null) {
			scrollPane_1 = new JScrollPane();
			scrollPane_1.setViewportView(getTextAreaJSON());
		}
		return scrollPane_1;
	}
	private JTextArea getTextAreaJSON() {
		if (textAreaJSON == null) {
			textAreaJSON = new JTextArea();
		}
		return textAreaJSON;
	}
	private JTextField getTextFieldAutor() {
		if (textFieldAutor == null) {
			textFieldAutor = new JTextField();
			textFieldAutor.setAutoscrolls(false);
			textFieldAutor.setBounds(7, 26, 116, 22);
			textFieldAutor.setColumns(10);
		}
		return textFieldAutor;
	}
	private JLabel getLblPesma() {
		if (lblPesma == null) {
			lblPesma = new JLabel("Pesma");
			lblPesma.setAlignmentX(Component.CENTER_ALIGNMENT);
			lblPesma.setHorizontalAlignment(SwingConstants.CENTER);
			lblPesma.setBounds(32, 53, 70, 16);
		}
		return lblPesma;
	}
	private JTextField getTextFieldPesma() {
		if (textFieldPesma == null) {
			textFieldPesma = new JTextField();
			textFieldPesma.setAutoscrolls(false);
			textFieldPesma.setBounds(7, 74, 116, 22);
			textFieldPesma.setColumns(10);
		}
		return textFieldPesma;
	}
	private JLabel getLblAlbum() {
		if (lblAlbum == null) {
			lblAlbum = new JLabel("Album");
			lblAlbum.setAlignmentX(Component.CENTER_ALIGNMENT);
			lblAlbum.setHorizontalAlignment(SwingConstants.CENTER);
			lblAlbum.setBounds(32, 109, 70, 16);
		}
		return lblAlbum;
	}
	private JTextField getTextFieldAlbum() {
		if (textFieldAlbum == null) {
			textFieldAlbum = new JTextField();
			textFieldAlbum.setAutoscrolls(false);
			textFieldAlbum.setBounds(7, 135, 116, 22);
			textFieldAlbum.setColumns(10);
		}
		return textFieldAlbum;
	}
	private JLabel getLblPozicijaNaMTVListi() {
		if (lblPozicijaNaMTVListi == null) {
			lblPozicijaNaMTVListi = new JLabel("Pozicija na MTV listi");
			lblPozicijaNaMTVListi.setAlignmentX(Component.CENTER_ALIGNMENT);
			lblPozicijaNaMTVListi.setHorizontalAlignment(SwingConstants.CENTER);
			lblPozicijaNaMTVListi.setBounds(0, 170, 134, 16);
		}
		return lblPozicijaNaMTVListi;
	}
	private JTextField getTextFieldPozicijaNaMTVListi() {
		if (textFieldPozicijaNaMTVListi == null) {
			textFieldPozicijaNaMTVListi = new JTextField();
			textFieldPozicijaNaMTVListi.setAutoscrolls(false);
			textFieldPozicijaNaMTVListi.setBounds(7, 195, 116, 22);
			textFieldPozicijaNaMTVListi.setColumns(10);
		}
		return textFieldPozicijaNaMTVListi;
	}
	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("Prikazi");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent o) {
				try {
					PrintWriter sacuvaj = new PrintWriter (new BufferedWriter(new FileWriter("muzika.out")));
					
					String autor = textFieldAutor.getText();
					String album = textFieldAlbum.getText();
					String pesma = textFieldPesma.getText();
					int pozicijaNaMTVListi = Integer.parseInt(textFieldPozicijaNaMTVListi.getText());
					
					Muzika m = new Muzika();
					m.setAlbum(album);
					m.setAutor(autor);
					m.setPesma(pesma);
					m.setPozicijaNaMTVListi(pozicijaNaMTVListi);
					
					pesme.add(m);
					sacuvaj.println(m);
					
					textAreaString.setText(m.toString());
					sacuvaj.close();
					
					
					
				} catch (IOException e) {
					e.printStackTrace();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
					
				}
			});
			btnNewButton.setAlignmentX(Component.CENTER_ALIGNMENT);
			btnNewButton.setBounds(7, 244, 116, 25);
		}
		return btnNewButton;
	}

	
}

