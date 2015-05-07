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

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;

import org.json.JSONException;
import org.json.JSONObject;

import java.awt.Toolkit;
import java.util.LinkedList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.JComboBox;
import javax.swing.JSpinner;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

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
	private JButton btnNewButton;
	private LinkedList<Muzika> pesme = new LinkedList<Muzika>();
	private JSpinner spinnerPozicijaNaMTVListi;

	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MuzikaGUI frame = new MuzikaGUI();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);

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
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent arg0) {
				int opcija =
						JOptionPane.showConfirmDialog(contentPane,
						 "Da li ste sigurni da zelite da izadjete iz aplikacije?", "Zatvaranje aplikacije",
						 JOptionPane.YES_NO_CANCEL_OPTION);
				if (opcija == JOptionPane.YES_OPTION)
					System.exit(0);
			}
		});
		setIconImage(Toolkit.getDefaultToolkit().getImage(MuzikaGUI.class.getResource("/com/sun/java/swing/plaf/windows/icons/Computer.gif")));
		setTitle("Muzika");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 459, 353);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[160.00,grow][156.00,grow][159.00,grow]", "[grow]"));
		contentPane.add(getPanel(), "cell 0 0,grow");
		contentPane.add(getPanel_1(), "cell 1 0,alignx center,aligny center");
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
			panel_1.setLayout(new MigLayout("", "[134px]", "[16px][22px][16px][22px][16px][22px][16px][22px][25px][]"));
			panel_1.add(getLblAutor(), "cell 0 0,alignx center,aligny top");
			panel_1.add(getTextFieldAutor(), "cell 0 1,alignx center,aligny top");
			panel_1.add(getLblPesma(), "cell 0 2,alignx center,aligny top");
			panel_1.add(getTextFieldPesma(), "cell 0 3,alignx center,aligny top");
			panel_1.add(getLblAlbum(), "cell 0 4,alignx center,aligny top");
			panel_1.add(getTextFieldAlbum(), "cell 0 5,alignx center,aligny top");
			panel_1.add(getLblPozicijaNaMTVListi(), "cell 0 6,growx,aligny top");
			panel_1.add(getSpinnerPozicijaNaMTVListi(), "cell 0 7,growx,aligny top");
			panel_1.add(getBtnNewButton(), "cell 0 9,growx,aligny top");
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
			textFieldAutor.setColumns(10);
		}
		return textFieldAutor;
	}
	private JLabel getLblPesma() {
		if (lblPesma == null) {
			lblPesma = new JLabel("Pesma");
			lblPesma.setAlignmentX(Component.CENTER_ALIGNMENT);
			lblPesma.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return lblPesma;
	}
	private JTextField getTextFieldPesma() {
		if (textFieldPesma == null) {
			textFieldPesma = new JTextField();
			textFieldPesma.setAutoscrolls(false);
			textFieldPesma.setColumns(10);
		}
		return textFieldPesma;
	}
	private JLabel getLblAlbum() {
		if (lblAlbum == null) {
			lblAlbum = new JLabel("Album");
			lblAlbum.setAlignmentX(Component.CENTER_ALIGNMENT);
			lblAlbum.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return lblAlbum;
	}
	private JTextField getTextFieldAlbum() {
		if (textFieldAlbum == null) {
			textFieldAlbum = new JTextField();
			textFieldAlbum.setAutoscrolls(false);
			textFieldAlbum.setColumns(10);
		}
		return textFieldAlbum;
	}
	private JLabel getLblPozicijaNaMTVListi() {
		if (lblPozicijaNaMTVListi == null) {
			lblPozicijaNaMTVListi = new JLabel("Pozicija na MTV listi");
			lblPozicijaNaMTVListi.setAlignmentX(Component.CENTER_ALIGNMENT);
			lblPozicijaNaMTVListi.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return lblPozicijaNaMTVListi;
	}
	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("Prikazi");
			btnNewButton.setAlignmentX(Component.CENTER_ALIGNMENT);
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent o) {
				try {
					PrintWriter sacuvaj = new PrintWriter (new BufferedWriter(new FileWriter("data/muzika.out")));
					
					Muzika m = new Muzika();
					
					if(textFieldAlbum.getText().isEmpty()) {
						m.setAlbum("nepoznato");
					} else {
						String album = textFieldAlbum.getText();
						m.setAlbum(album);
					}
					if(textFieldAutor.getText().isEmpty()) {
						m.setAutor("nepoznato");
					} else {
						String autor = textFieldAutor.getText();
						m.setAutor(autor);
					}
					if(textFieldPesma.getText().isEmpty()) {
						m.setPesma("nepoznato");
					} else {
						String pesma = textFieldPesma.getText();
						m.setPesma(pesma);
					}
					
					int i;
					i = Integer.parseInt(spinnerPozicijaNaMTVListi.getValue().toString());
					if ( i == 0) {
						m.setPozicijaNaMTVListi(-1);
					} else {
						m.setPozicijaNaMTVListi(i);
					}
								
					
					if(!(pesme.contains(m))) {
						pesme.add(m);
					}

					sacuvaj.println(m);
					
					textAreaString.setText(m.toString());
					sacuvaj.close();
					
				} catch (IOException e) {
					e.printStackTrace();
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				JSONObject obj = new JSONObject();
				try {
					
					if(textFieldAlbum.getText().isEmpty()) {
						obj.put("album", "nepoznato");
					} else {
						obj.put("album", textFieldAlbum.getText());
					}
					if(textFieldAutor.getText().isEmpty()) {
						obj.put("autor", "nepoznato");
					} else {
						obj.put("autor", textFieldAutor.getText());
					}
					if(textFieldPesma.getText().isEmpty()) {
						obj.put("pesma", "nepoznato");
					} else {
						obj.put("pesma", textFieldPesma.getText());
					}
					
					int i;
					i = Integer.parseInt(spinnerPozicijaNaMTVListi.getValue().toString());
					if( i == 0) {
						obj.put("pozicijaNaMTVListi", "Pesma se ne nalazai na MTV listi");
					} else {
						obj.put("pozicijaNaMTVListi", i);
					}
					
					
					textAreaJSON.setText(obj.toString(4));
					
				} catch (JSONException e) {
					System.out.println("Greska!");
				}
					
				}
			});
		}
		return btnNewButton;
	}
	private JSpinner getSpinnerPozicijaNaMTVListi() {
		if (spinnerPozicijaNaMTVListi == null) {
			spinnerPozicijaNaMTVListi = new JSpinner();
		}
		return spinnerPozicijaNaMTVListi;
	}
}

