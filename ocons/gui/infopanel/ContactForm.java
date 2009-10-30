package gui.infopanel;

import javax.swing.JPanel;
import java.awt.Frame;
import java.awt.BorderLayout;
import javax.swing.JDialog;
import java.awt.Dimension;
import javax.swing.JLabel;
import java.awt.Rectangle;
import settings.*;
import javax.swing.JTextField;
import javax.swing.JComboBox;

import com.toedter.calendar.JDateChooser;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.border.Border;

public class ContactForm extends InfoPanelDialog {

	private static final long serialVersionUID = 1L;

	private JPanel jContentPane = null;
	private JLabel lblPhone = null;
	private JTextField fldPhone = null;
	private JLabel lblWhereFind = null;
	private JComboBox cmbWhereFind = null;
	private JLabel lblName = null;
	private JTextField fldName = null;
	private JLabel lblDate = null;
	private JDateChooser dtDate = null;
	private JLabel lblStatus = null;
	private JComboBox cmbStatus = null;
	private JTextArea txtInfo = null;
	private JButton btnSave = null;
	private JButton btnCancel = null;

	/**
	 * @param owner
	 */
	public ContactForm(String name, String title) {
		super(name, title);
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(340, 279);
		this.setTitle(Localizator.IP_Contact);
		this.setContentPane(getJContentPane());
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			lblStatus = new JLabel();
			lblStatus.setBounds(new Rectangle(76, 134, 71, 19));
			lblStatus.setText(Localizator.IP_ContactStatus);
			lblDate = new JLabel();
			lblDate.setBounds(new Rectangle(95, 104, 51, 19));
			lblDate.setText(Localizator.IP_ContactDate);
			lblName = new JLabel();
			lblName.setBounds(new Rectangle(30, 75, 46, 19));
			lblName.setText(Localizator.IP_ContactName);
			lblWhereFind = new JLabel();
			lblWhereFind.setBounds(new Rectangle(16, 45, 134, 19));
			lblWhereFind.setText(Localizator.IP_ContactWhereFind);
			lblPhone = new JLabel();
			lblPhone.setBounds(new Rectangle(16, 15, 107, 19));
			lblPhone.setText(Localizator.IP_ContactPhone);
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.add(lblPhone, null);
			jContentPane.add(getFldPhone(), null);
			jContentPane.add(lblWhereFind, null);
			jContentPane.add(getCmbWhereFind(), null);
			jContentPane.add(lblName, null);
			jContentPane.add(getFldName(), null);
			jContentPane.add(lblDate, null);
			jContentPane.add(getDtDate(),null);
			jContentPane.add(lblStatus, null);
			jContentPane.add(getCmbStatus(), null);
			jContentPane.add(getTxtInfo(), null);
			jContentPane.add(getBtnSave(), null);
			jContentPane.add(getBtnCancel(), null);
		}
		return jContentPane;
	}

	/**
	 * This method initializes fldPhone	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getFldPhone() {
		if (fldPhone == null) {
			fldPhone = new JTextField();
			fldPhone.setBounds(new Rectangle(134, 15, 182, 19));
		}
		return fldPhone;
	}

	/**
	 * This method initializes cmbWhereFind	
	 * 	
	 * @return javax.swing.JComboBox	
	 */
	private JComboBox getCmbWhereFind() {
		if (cmbWhereFind == null) {
			cmbWhereFind = new JComboBox();
			cmbWhereFind.setBounds(new Rectangle(166, 45, 149, 19));
		}
		return cmbWhereFind;
	}

	/**
	 * This method initializes fldName	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getFldName() {
		if (fldName == null) {
			fldName = new JTextField();
			fldName.setBounds(new Rectangle(90, 75, 213, 19));
		}
		return fldName;
	}
	
	private JDateChooser getDtDate(){
		if (dtDate == null) {
			dtDate = new JDateChooser();
			dtDate.setBounds(156, 104, 89, 19);
			
		}
		return dtDate;
	}

	/**
	 * This method initializes cmbStatus	
	 * 	
	 * @return javax.swing.JComboBox	
	 */
	private JComboBox getCmbStatus() {
		if (cmbStatus == null) {
			cmbStatus = new JComboBox();
			cmbStatus.setBounds(new Rectangle(157, 134, 122, 19));
		}
		return cmbStatus;
	}

	/**
	 * This method initializes txtInfo	
	 * 	
	 * @return javax.swing.JTextArea	
	 */
	private JTextArea getTxtInfo() {
		if (txtInfo == null) {
			txtInfo = new JTextArea();
			txtInfo.setBounds(new Rectangle(16, 165, 302, 44));			
		}
		return txtInfo;
	}

	/**
	 * This method initializes btnSave	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getBtnSave() {
		if (btnSave == null) {
			btnSave = new JButton();
			btnSave.setBounds(new Rectangle(58, 220, 97, 20));
			btnSave.setText(Localizator.G_Save);
		}
		return btnSave;
	}

	/**
	 * This method initializes btnCancel	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getBtnCancel() {
		if (btnCancel == null) {
			btnCancel = new JButton();
			btnCancel.setBounds(new Rectangle(178, 221, 97, 19));
			btnCancel.setText(Localizator.G_Cancel);
		}
		return btnCancel;
	}

	public void run(boolean isEdit) {
		// TODO Автоматически созданная заглушка метода
		
	}

}  //  @jve:decl-index=0:visual-constraint="10,10"
