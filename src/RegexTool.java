import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ItemEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;

/*
 * Created on Mar 1, 2005
 */

/**
 * @author mark
 */
@SuppressWarnings("serial")
public class RegexTool extends JFrame {

	private javax.swing.JPanel jContentPane = null;
	private JPanel pnlButtons = null;
	private JPanel pnlMain = null;
	private JTextField tfRE = null;
	private JLabel jLabel = null;
	private JButton btnMatch = null;
	private JButton btnExit = null;
	private JLabel jLabel4;
	private JTextField txtFormat;
	private JLabel jLabel3;
	private JTextArea taFormatted;
	private JScrollPane jScrollPane2;
	private JPanel jPanel2;
	private JLabel jLabel5;
	private JTable jTable;
	private JScrollPane jScrollPane3;
	private JPanel jPanel1;
	private JSplitPane splitBottom;

	private JLabel jLabel2;
	private JTextArea taMatched;
	private JScrollPane jScrollPane1;
	private JPanel pnlMatches;
	private JTextArea taText;
	private JScrollPane jScrollPane;
	private JLabel jLabel1;
	private JPanel pnlTextToProcess;
	private JSplitPane splitTop;
	private JSplitPane splitMain;

	private JButton btnFormat = null;
	private String[] groups;
	private List groupList;

	private Font mono = new Font("Monospaced", Font.PLAIN, 12);
	
	private JCheckBox cbLiteralize;
	private String re;
	private JButton jButton = null;
	private JButton jButton1 = null;
	private JButton jButton2 = null;
	private JPanel jPanel = null;
	private JPanel jPanel3 = null;
	private JCheckBox cbMultiline = null;
	private JLabel lblMultiline = null;
	private JLabel lblDirtyHackySpacer = null;
	/**
	 * This method initializes pnlButtons
	 * 
	 * @return javax.swing.JPanel
	 */
	@SuppressWarnings({"all"})
	private JPanel getPnlButtons() {
		if (this.pnlButtons == null) {
			try {
				lblDirtyHackySpacer = new JLabel();
				lblDirtyHackySpacer.setText("   ");
				lblMultiline = new JLabel();
				lblMultiline.setText("Multiline?");
				this.pnlButtons = new JPanel();
				pnlButtons.add(lblMultiline, null);
				pnlButtons.add(getCbMultiline(), null);
				pnlButtons.add(lblDirtyHackySpacer, null);
				this.pnlButtons.add(getBtnMatch(), null);
				this.pnlButtons.add(getJButton(), null);
				this.pnlButtons.add(getBtnExit(), null);
			} catch (java.lang.Throwable e) {
				e.printStackTrace();
			}
		}
		return this.pnlButtons;
	}

	/**
	 * This method initializes jPanel1
	 * 
	 * @return javax.swing.JPanel
	 */
	@SuppressWarnings({"all"})
	private JPanel getPnlMain() {
		if (pnlMain == null) {
			try {
				GridBagConstraints gridBagConstraints32 = new GridBagConstraints();
				GridBagConstraints gridBagConstraints71 = new GridBagConstraints();
				GridBagConstraints gridBagConstraints11 = new GridBagConstraints();
				GridBagConstraints gridBagConstraints21 = new GridBagConstraints();
				GridBagConstraints gridBagConstraints31 = new GridBagConstraints();
				GridBagConstraints gridBagConstraints51 = new GridBagConstraints();
				this.jLabel = new JLabel();
				GridBagConstraints gridBagConstraints1 = new GridBagConstraints();
				GridBagConstraints gridBagConstraints2 = new GridBagConstraints();
				GridBagConstraints gridBagConstraints3 = new GridBagConstraints();
				GridBagConstraints gridBagConstraints5 = new GridBagConstraints();
				GridBagConstraints gridBagConstraints7 = new GridBagConstraints();
				GridBagConstraints gridBagConstraints8 = new GridBagConstraints();
				this.pnlMain = new JPanel();
				this.pnlMain.setLayout(new GridBagLayout());
				gridBagConstraints1.gridx = 1;
				gridBagConstraints1.gridy = 0;
				gridBagConstraints1.weightx = 1.0;
				gridBagConstraints1.fill = java.awt.GridBagConstraints.HORIZONTAL;
				gridBagConstraints1.insets = new java.awt.Insets(0, 0, 0, 5);
				gridBagConstraints2.gridx = 0;
				gridBagConstraints2.gridy = 0;
				gridBagConstraints2.anchor = java.awt.GridBagConstraints.EAST;
				gridBagConstraints2.insets = new java.awt.Insets(0, 5, 0, 5);
				this.jLabel.setText("Regular Expression:");
				gridBagConstraints3.gridx = 0;
				gridBagConstraints3.gridy = 1;
				gridBagConstraints3.insets = new java.awt.Insets(5, 0, 0, 0);
				gridBagConstraints3.anchor = java.awt.GridBagConstraints.CENTER;
				gridBagConstraints3.gridwidth = 2;
				gridBagConstraints5.gridx = 0;
				gridBagConstraints5.gridy = 3;
				gridBagConstraints5.insets = new java.awt.Insets(5, 0, 0, 0);
				gridBagConstraints5.anchor = java.awt.GridBagConstraints.CENTER;
				gridBagConstraints5.gridwidth = 2;
				gridBagConstraints7.gridx = 0;
				gridBagConstraints7.gridy = 2;
				gridBagConstraints7.weightx = 1.0;
				gridBagConstraints7.weighty = 1.0;
				gridBagConstraints7.fill = java.awt.GridBagConstraints.BOTH;
				gridBagConstraints7.insets = new java.awt.Insets(0, 5, 0, 5);
				gridBagConstraints7.gridwidth = 2;
				gridBagConstraints8.gridx = 0;
				gridBagConstraints8.gridy = 4;
				gridBagConstraints8.weightx = 1.0;
				gridBagConstraints8.weighty = 1.0;
				gridBagConstraints8.fill = java.awt.GridBagConstraints.BOTH;
				gridBagConstraints8.insets = new java.awt.Insets(0, 5, 0, 5);
				gridBagConstraints8.gridwidth = 2;
				gridBagConstraints11.gridx = 0;
				gridBagConstraints11.gridy = 7;
				gridBagConstraints11.anchor = java.awt.GridBagConstraints.EAST;
				gridBagConstraints11.insets = new java.awt.Insets(5, 5, 0, 5);
				gridBagConstraints21.gridx = 1;
				gridBagConstraints21.gridy = 7;
				gridBagConstraints21.weightx = 1.0;
				gridBagConstraints21.fill = java.awt.GridBagConstraints.HORIZONTAL;
				gridBagConstraints21.insets = new java.awt.Insets(5, 0, 0, 5);
				gridBagConstraints31.gridx = 0;
				gridBagConstraints31.gridy = 8;
				gridBagConstraints31.insets = new java.awt.Insets(5, 0, 0, 0);
				gridBagConstraints31.anchor = java.awt.GridBagConstraints.CENTER;
				gridBagConstraints31.gridwidth = 2;
				gridBagConstraints51.gridx = 0;
				gridBagConstraints51.gridy = 9;
				gridBagConstraints51.weightx = 1.0;
				gridBagConstraints51.weighty = 1.0;
				gridBagConstraints51.fill = java.awt.GridBagConstraints.BOTH;
				gridBagConstraints51.insets = new java.awt.Insets(0, 5, 0, 5);
				gridBagConstraints51.gridwidth = 2;
				gridBagConstraints71.gridx = 0;
				gridBagConstraints71.gridy = 6;
				gridBagConstraints71.weightx = 1.0;
				gridBagConstraints71.weighty = 1.0;
				gridBagConstraints71.fill = java.awt.GridBagConstraints.BOTH;
				gridBagConstraints71.insets = new java.awt.Insets(0, 5, 0, 5);
				gridBagConstraints71.gridwidth = 2;
				gridBagConstraints32.gridx = 0;
				gridBagConstraints32.gridy = 5;
				gridBagConstraints32.anchor = java.awt.GridBagConstraints.CENTER;
				gridBagConstraints32.insets = new java.awt.Insets(5, 0, 0, 0);
				gridBagConstraints32.gridwidth = 2;
				this.pnlMain.add(getTfRE(), new GridBagConstraints(1, 0, 1, 1, 1.0, 0.0,
						GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
						new Insets(5, 0, 5, 5), 0, 0));
				
				this.pnlMain.add(getCbLiteralize(), new GridBagConstraints(2, 0, 1, 1, 0.0, 0.0,
						GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
						new Insets(5, 0, 5, 5), 0, 0) );
				
				this.pnlMain.add(new JLabel("Literalize"), new GridBagConstraints(3, 0, 1, 1, 0.0, 0.0,
						GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
						new Insets(5, 0, 5, 5), 0, 0) );
				
				
				this.pnlMain.add(this.jLabel, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
						GridBagConstraints.EAST, GridBagConstraints.NONE, new Insets(
								5, 5, 5, 5), 0, 0));
				
				this.pnlMain.add(getSplitMain(), new GridBagConstraints(0, 5, 4, 1, 1.0,
						1.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH,
						new Insets(5, 5, 5, 5), 0, 0));
			} catch (java.lang.Throwable e) {
				e.printStackTrace();
			}
		}
		return this.pnlMain;
	}

	/**
	 * This method initializes jTextField
	 * 
	 * @return javax.swing.JTextField
	 */
	@SuppressWarnings({"all"})
	private JTextField getTfRE() {
		if (this.tfRE == null) {
			try {
				this.tfRE = new JTextField();
				this.tfRE.setFont(this.mono);
			} catch (java.lang.Throwable e) {
				e.printStackTrace();
			}
		}
		return this.tfRE;
	}

	/**
	 * This method initializes jButton
	 * 
	 * @return javax.swing.JButton
	 */
	@SuppressWarnings({"all"})
	private JButton getBtnMatch() {
		if (this.btnMatch == null) {
			try {
				this.btnMatch = new JButton();
				this.btnMatch.setText("Match");
				this.btnMatch.addActionListener(new java.awt.event.ActionListener() {
					public void actionPerformed(java.awt.event.ActionEvent e) {
						btnMatchClicked();
					}
				});
			} catch (java.lang.Throwable e) {
				e.printStackTrace();
			}
		}
		return this.btnMatch;
	}

	/**
	 * 
	 */
	@SuppressWarnings(value= {"all"})
	protected void btnMatchClicked() {
		try {
			taMatched.setText("");

			if(cbMultiline.isSelected()) {
				doMultilineMatch();
			} else {
				doLineByLineMatch();
			}			
			

		} catch (Exception e) {
			e.printStackTrace();
			taMatched.setText(e.getMessage());
		}
	}

	
	
	private void doLineByLineMatch() {
		groupList = new ArrayList();
		String re = tfRE.getText();
		String text = taText.getText();
		
		String[] input = text.split("\n");

		Pattern pattern = Pattern.compile(re);

		DefaultTableModel model = new DefaultTableModel();
		jTable.setModel(model);

		int numMatches = 0;

		for (int i = 0; i < input.length; i++) {
			String line = input[i];

			Matcher matcher = pattern.matcher(line);
			if (matcher.find()) {

				numMatches++;

				int groupCount = matcher.groupCount();

				model.setColumnCount(groupCount);

				Object[] headers = new Object[groupCount];

				for (int k = 0; k < groupCount; k++) {
					headers[k] = new Integer(k + 1);
				}

				model.setColumnIdentifiers(headers);

				taMatched.append(matcher.group(0) + "\n");

				groups = new String[matcher.groupCount()];
				for (int j = 1; j <= matcher.groupCount(); j++) {
					String s = matcher.group(j);
					groups[j - 1] = s;
				}

				model.addRow(groups);
				groupList.add(groups);
			}
		}

		taMatched.append("Matched " + numMatches + " line(s) out of "
				+ input.length + " line(s) of input.");
	}

	private void doMultilineMatch() {
		groupList = new ArrayList();
		String re = tfRE.getText();
		String text = taText.getText();
		
		Pattern pattern = Pattern.compile(re, Pattern.MULTILINE+Pattern.DOTALL);

		DefaultTableModel model = new DefaultTableModel();
		jTable.setModel(model);

		int numMatches = 0;

		int i = 0;

		Matcher matcher = pattern.matcher(text);

		while (matcher.find(i)) {

			i=matcher.end();

			numMatches++;

			int groupCount = matcher.groupCount();

			model.setColumnCount(groupCount);

			Object[] headers = new Object[groupCount];

			for (int k = 0; k < groupCount; k++) {
				headers[k] = new Integer(k + 1);
			}

			model.setColumnIdentifiers(headers);

			taMatched.append(matcher.group(0) + "\n");

			groups = new String[matcher.groupCount()];
			for (int j = 1; j <= matcher.groupCount(); j++) {
				String s = matcher.group(j);
				groups[j - 1] = s;
			}

			model.addRow(groups);
			groupList.add(groups);
		} 

		taMatched.append("Found " + numMatches + " matches.");		

	}

	/**
	 * This method initializes jButton1
	 * 
	 * @return javax.swing.JButton
	 */
	@SuppressWarnings({"all"})
	private JButton getBtnExit() {
		if (btnExit == null) {
			try {
				btnExit = new JButton();
				btnExit.setText("Exit");
				btnExit.addActionListener(new java.awt.event.ActionListener() {
					public void actionPerformed(java.awt.event.ActionEvent e) {
						System.exit(0);
					}
				});
			} catch (java.lang.Throwable e) {
				e.printStackTrace();
			}
		}
		return btnExit;
	}

	protected void cbLiteralClicked(ItemEvent e) {
		if(e.getStateChange() == ItemEvent.SELECTED) {
			this.re = this.tfRE.getText();
			String literalizedRE = this.re.replaceAll("\\\\", "\\\\\\\\").replaceAll("\"",
			"\\\\\"");
			this.tfRE.setText(literalizedRE);
		} else {
			this.tfRE.setText(this.re);
		}
	}

	/**
	 * This method initializes jButton
	 * 
	 * @return javax.swing.JButton
	 */
	@SuppressWarnings({"all"})
	private JButton getJButton() {
		if (btnFormat == null) {
			try {
				btnFormat = new JButton();
				btnFormat.setText("Format");
				btnFormat.addActionListener(new java.awt.event.ActionListener() {
					public void actionPerformed(java.awt.event.ActionEvent e) {
						btnFormatClick();
					}
				});
			} catch (java.lang.Throwable e) {
				e.printStackTrace();
			}
		}
		return btnFormat;
	}

	protected void btnFormatClick() {
		if (this.groupList == null || this.txtFormat.getText().length() == 0)
			return;

		this.taFormatted.setText("");

		String formatter = this.txtFormat.getText()
				.replaceAll("\\\\(\\d*)", "%$1\\$s");

		Iterator it = this.groupList.iterator();
		while (it.hasNext()) {
			Object[] groups = (Object[]) it.next();
			this.taFormatted.append(String.format(formatter, groups) + "\n");
		}
	}

	/**
	 * This method initializes jButton	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButton2() {
		if (jButton == null) {
			jButton = new JButton();
			jButton.setText("x");
			jButton.setFont(new Font("SansSerif", Font.PLAIN, 8));
			jButton.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					taText.setText("");
				}
			});
		}
		return jButton;
	}

	/**
	 * This method initializes jButton1	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButton1() {
		if (jButton1 == null) {
			jButton1 = new JButton();
			jButton1.setFont(new Font("SansSerif", Font.PLAIN, 8));
			jButton1.setText("x");
			jButton1.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					taMatched.setText("");
				}
			});
		}
		return jButton1;
	}

	/**
	 * This method initializes jButton2	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButton22() {
		if (jButton2 == null) {
			jButton2 = new JButton();
			jButton2.setFont(new Font("SansSerif", Font.PLAIN, 8));
			jButton2.setText("x");
			jButton2.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					taFormatted.setText("");
				}
			});
		}
		return jButton2;
	}

	/**
	 * This method initializes jPanel	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanel() {
		if (jPanel == null) {
			GridBagConstraints gridBagConstraints4 = new GridBagConstraints();
			gridBagConstraints4.gridx = 0;
			gridBagConstraints4.gridy = 0;
			gridBagConstraints4.weightx = 1;
			GridBagConstraints gridBagConstraints = new GridBagConstraints();
			gridBagConstraints.gridx = 0;
			gridBagConstraints.gridy = 0;
			gridBagConstraints.anchor = GridBagConstraints.WEST;
			jPanel = new JPanel();
			jPanel.setLayout(new GridBagLayout());
			jPanel.add(getJButton2(), gridBagConstraints);
			jPanel.add(getJLabel1(), gridBagConstraints4);
		}
		return jPanel;
	}

	/**
	 * This method initializes jPanel3	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanel3() {
		if (jPanel3 == null) {
			GridBagConstraints gridBagConstraints9 = new GridBagConstraints();
			gridBagConstraints9.gridx = 0;
			gridBagConstraints9.gridy = 0;
			gridBagConstraints9.weightx = 1;
			GridBagConstraints gridBagConstraints6 = new GridBagConstraints();
			gridBagConstraints6.gridx = 0;
			gridBagConstraints6.gridy = 0;
			gridBagConstraints6.anchor = GridBagConstraints.WEST;
			jPanel3 = new JPanel();
			jPanel3.setLayout(new GridBagLayout());
			jPanel3.add(getJButton1(), gridBagConstraints6);
			jPanel3.add(getJLabel2(), gridBagConstraints9);
		}
		return jPanel3;
	}

	/**
	 * This method initializes cbMultiline	
	 * 	
	 * @return javax.swing.JCheckBox	
	 */
	private JCheckBox getCbMultiline() {
		if (cbMultiline == null) {
			cbMultiline = new JCheckBox();
		}
		return cbMultiline;
	}

	public static void main(String[] args) {
		
		if(System.getProperty("os.name").equalsIgnoreCase("linux")) {
			System.setProperty("swing.defaultlaf", "com.sun.java.swing.plaf.gtk.GTKLookAndFeel");
		} else {
			System.setProperty("swing.defaultlaf", UIManager.getSystemLookAndFeelClassName());
		}

		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new RegexTool().setVisible(true);
			}
		});		
	}

	/**
	 * This is the default constructor
	 */
	public RegexTool() {
		super();
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
		this.setSize(600, 500);
		this.setContentPane(getJContentPane());
		this.setTitle("RegEx Tool");
		this.validate();
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	@SuppressWarnings({"all"})
	private javax.swing.JPanel getJContentPane() {
		if (jContentPane == null) {
			jContentPane = new javax.swing.JPanel();
			jContentPane.setLayout(new java.awt.BorderLayout());
			jContentPane.add(getPnlButtons(), java.awt.BorderLayout.SOUTH);
			jContentPane.add(getPnlMain(), java.awt.BorderLayout.CENTER);
		}
		return jContentPane;
	}

	@SuppressWarnings({"all"})
	private JSplitPane getSplitMain() {
		if (splitMain == null) {
			splitMain = new JSplitPane();
			splitMain.setOrientation(JSplitPane.VERTICAL_SPLIT);
			splitMain.setResizeWeight(0.5);
			splitMain.setOneTouchExpandable(true);
			splitMain.setContinuousLayout(true);
			splitMain.add(getSplitTop(), JSplitPane.TOP);
			splitMain.add(getSplitBottom(), JSplitPane.BOTTOM);
		}
		return splitMain;
	}

	@SuppressWarnings({"all"})
	private JSplitPane getSplitTop() {
		if (splitTop == null) {
			splitTop = new JSplitPane();
			splitTop.setOrientation(JSplitPane.VERTICAL_SPLIT);
			splitTop.setResizeWeight(0.5);
			splitTop.setOneTouchExpandable(true);
			splitTop.setContinuousLayout(true);
			splitTop.add(getPnlTextToProcess(), JSplitPane.TOP);
			splitTop.add(getPnlMatches(), JSplitPane.BOTTOM);
		}
		return splitTop;
	}

	@SuppressWarnings({"all"})
	private JPanel getPnlTextToProcess() {
		if (pnlTextToProcess == null) {
			pnlTextToProcess = new JPanel();
			pnlTextToProcess.setLayout(new BorderLayout());
			pnlTextToProcess.add(getJPanel(), BorderLayout.NORTH);
			pnlTextToProcess.add(getJScrollPane(), BorderLayout.CENTER);
		}
		return pnlTextToProcess;
	}

	@SuppressWarnings({"all"})
	private JLabel getJLabel1() {
		if (jLabel1 == null) {
			jLabel1 = new JLabel();
			jLabel1.setText("Text to Process");
			jLabel1.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return jLabel1;
	}

	/**
	 * This method initializes jScrollPane
	 * 
	 * @return javax.swing.JScrollPane
	 */
	@SuppressWarnings({"all"})
	private JScrollPane getJScrollPane() {
		if (jScrollPane == null) {
			try {
				jScrollPane = new JScrollPane();
				jScrollPane.setViewportView(getTaText());
			} catch (java.lang.Throwable e) {
				e.printStackTrace();
			}
		}
		return jScrollPane;
	}

	/**
	 * This method initializes jTextArea
	 * 
	 * @return javax.swing.JTextArea
	 */
	@SuppressWarnings({"all"})
	private JTextArea getTaText() {
		if (taText == null) {
			try {
				taText = new JTextArea();
				taText.setFont(mono);
			} catch (java.lang.Throwable e) {
				e.printStackTrace();
			}
		}
		return taText;
	}

	@SuppressWarnings({"all"})
	private JPanel getPnlMatches() {
		if (pnlMatches == null) {
			pnlMatches = new JPanel();
			pnlMatches.setLayout(new BorderLayout());
			GridBagConstraints gbc = new GridBagConstraints();
			gbc.gridx = -1;
			gbc.gridy = -1;
			gbc.anchor=GridBagConstraints.WEST;
			pnlMatches.add(getJScrollPane1(), BorderLayout.CENTER);
			pnlMatches.add(getJPanel3(), BorderLayout.NORTH);
		}
		return pnlMatches;
	}

	/**
	 * This method initializes jScrollPane1
	 * 
	 * @return javax.swing.JScrollPane
	 */
	@SuppressWarnings({"all"})
	private JScrollPane getJScrollPane1() {
		if (jScrollPane1 == null) {
			try {
				jScrollPane1 = new JScrollPane();
				jScrollPane1.setAutoscrolls(true);
				jScrollPane1.setViewportView(getTaMatched());
			} catch (java.lang.Throwable e) {
				e.printStackTrace();
			}
		}
		return jScrollPane1;
	}

	/**
	 * This method initializes jTextArea1
	 * 
	 * @return javax.swing.JTextArea
	 */
	@SuppressWarnings({"all"})
	private JTextArea getTaMatched() {
		if (taMatched == null) {
			try {
				taMatched = new JTextArea();
				taMatched.setFont(mono);
			} catch (java.lang.Throwable e) {
				e.printStackTrace();
			}
		}
		return taMatched;
	}

	@SuppressWarnings({"all"})
	private JLabel getJLabel2() {
		if (jLabel2 == null) {
			jLabel2 = new JLabel();
			jLabel2.setText("Matches");
			jLabel2.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return jLabel2;
	}

	@SuppressWarnings({"all"})
	private JSplitPane getSplitBottom() {
		if (splitBottom == null) {
			splitBottom = new JSplitPane();
			splitBottom.setOrientation(JSplitPane.VERTICAL_SPLIT);
			splitBottom.setResizeWeight(0.5);
			splitBottom.setOneTouchExpandable(true);
			splitBottom.setContinuousLayout(true);
			splitBottom.add(getJPanel1(), JSplitPane.TOP);
			splitBottom.add(getJPanel2(), JSplitPane.BOTTOM);
		}
		return splitBottom;
	}

	@SuppressWarnings({"all"})
	private JPanel getJPanel1() {
		if (jPanel1 == null) {
			jPanel1 = new JPanel();
			BorderLayout jPanel1Layout = new BorderLayout();
			jPanel1.setLayout(jPanel1Layout);
			jPanel1.add(getJScrollPane3(), BorderLayout.CENTER);
			jPanel1.add(getJLabel5(), BorderLayout.NORTH);
		}
		return jPanel1;
	}

	/**
	 * This method initializes jScrollPane3
	 * 
	 * @return javax.swing.JScrollPane
	 */
	@SuppressWarnings({"all"})
	private JScrollPane getJScrollPane3() {
		if (jScrollPane3 == null) {
			try {
				jScrollPane3 = new JScrollPane();
				jScrollPane3.setViewportView(getJTable());
			} catch (java.lang.Throwable e) {
				e.printStackTrace();
			}
		}
		return jScrollPane3;
	}

	/**
	 * This method initializes jTable
	 * 
	 * @return javax.swing.JTable
	 */
	@SuppressWarnings({"all"})
	private JTable getJTable() {
		if (jTable == null) {
			try {
				jTable = new JTable();
				jTable
						.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
			} catch (java.lang.Throwable e) {
				e.printStackTrace();
			}
		}
		return jTable;
	}

	@SuppressWarnings({"all"})
	private JLabel getJLabel5() {
		if (jLabel5 == null) {
			jLabel5 = new JLabel();
			jLabel5.setText("Groups");
			jLabel5.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return jLabel5;
	}

	@SuppressWarnings({"all"})
	private JPanel getJPanel2() {
		if (jPanel2 == null) {
			GridBagConstraints gridBagConstraints13 = new GridBagConstraints();
			gridBagConstraints13.gridx = 0;
			gridBagConstraints13.anchor = GridBagConstraints.WEST;
			gridBagConstraints13.gridy = 3;
			GridBagConstraints gridBagConstraints10 = new GridBagConstraints(0, 3, 2, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(5, 0, 5, 0), 0, 0);
			jPanel2 = new JPanel();
			GridBagLayout jPanel2Layout = new GridBagLayout();
			jPanel2.setLayout(jPanel2Layout);
			jPanel2.add(getJScrollPane2(), new GridBagConstraints(0, 14, 2, 1,
					1.0, 1.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH,
					new Insets(0, 0, 0, 0), 0, 0));
			jPanel2.add(getJLabel3(), new GridBagConstraints(0, 2, 1, 1, 0.0, 0.0,
					GridBagConstraints.EAST, GridBagConstraints.NONE, new Insets(5,
							5, 5, 5), 0, 0));
			jPanel2.add(getTxtFormat(), new GridBagConstraints(1, 2, 1, 1, 1.0,
					0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
					new Insets(5, 0, 5, 5), 0, 0));
			jPanel2.add(getJLabel4(), gridBagConstraints10);
			jPanel2.add(getJButton22(), gridBagConstraints13);
		}
		return jPanel2;
	}

	/**
	 * This method initializes jScrollPane2
	 * 
	 * @return javax.swing.JScrollPane
	 */
	@SuppressWarnings({"all"})
	private JScrollPane getJScrollPane2() {
		if (jScrollPane2 == null) {
			try {
				jScrollPane2 = new JScrollPane();
				jScrollPane2.setAutoscrolls(true);
				jScrollPane2.setViewportView(getTaFormatted());
			} catch (java.lang.Throwable e) {
				e.printStackTrace();
			}
		}
		return jScrollPane2;
	}

	/**
	 * This method initializes jTextArea
	 * 
	 * @return javax.swing.JTextArea
	 */
	@SuppressWarnings({"all"})
	private JTextArea getTaFormatted() {
		if (taFormatted == null) {
			try {
				taFormatted = new JTextArea();
				taFormatted.setFont(mono);
			} catch (java.lang.Throwable e) {
				e.printStackTrace();
			}
		}
		return taFormatted;
	}

	@SuppressWarnings({"all"})
	private JLabel getJLabel3() {
		if (jLabel3 == null) {
			jLabel3 = new JLabel();
			jLabel3.setText("Formatting String:");
		}
		return jLabel3;
	}

	/**
	 * This method initializes jTextField
	 * 
	 * @return javax.swing.JTextField
	 */
	@SuppressWarnings({"all"})
	private JTextField getTxtFormat() {
		if (txtFormat == null) {
			try {
				txtFormat = new JTextField();
				txtFormat.setFont(mono);
			} catch (java.lang.Throwable e) {
				e.printStackTrace();
			}
		}
		return txtFormat;
	}

	@SuppressWarnings({"all"})
	private JLabel getJLabel4() {
		if (jLabel4 == null) {
			jLabel4 = new JLabel();
			jLabel4.setText("Formatted Text");
		}
		return jLabel4;
	}

	public JCheckBox getCbLiteralize() {
		if (this.cbLiteralize == null) {
			this.cbLiteralize = new JCheckBox();
			this.cbLiteralize.addItemListener(new java.awt.event.ItemListener() {
				public void itemStateChanged(ItemEvent e) {
					cbLiteralClicked(e);
				}
			});
		}
		return this.cbLiteralize;
	}

}