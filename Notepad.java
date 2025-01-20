package Notepad;

import java.awt.FileDialog;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Notepad {
	private JFrame frame;
	private JTextArea textArea;
	private JMenuBar menuBar;
	private JMenu fileMenu, languageMenu, formatMenu, commandPrompt;

	private JMenuItem itemNew, itemNewWindow, itemOpen, itemSaveAs, itemSave, itemExit;

	

	private JMenuItem itemWordWrap, itemFont, itemFontSize;

	private JMenuItem itemCMD;
	private BufferedReader br = null;
	private BufferedWriter bw = null;

	private String openPath = null;
	private String openFileName = null;
	private boolean wrap = false;

	private String fontstyle = "Arial";
	private int defFontSize = 34;

	private Font arial, newRoman, consolas;

	public Notepad() {

		createFrame();
		createTextArea();
		createScrollBars();
		createMenuBar();
		createFileMenuItems();
		createFormatMenuItems();
		createCommandPromptItem();
		createLanguageItems();
	}
	

	public JFrame getFrame() {
		return frame;
	}


	public void setFrame(JFrame frame) {
		this.frame = frame;
	}


	public JTextArea getTextArea() {
		return textArea;
	}


	public void setTextArea(JTextArea textArea) {
		this.textArea = textArea;
	}


	public JMenuBar getMenuBar() {
		return menuBar;
	}


	public void setMenuBar(JMenuBar menuBar) {
		this.menuBar = menuBar;
	}


	public JMenu getFileMenu() {
		return fileMenu;
	}


	public void setFileMenu(JMenu fileMenu) {
		this.fileMenu = fileMenu;
	}


	public JMenu getLanguageMenu() {
		return languageMenu;
	}


	public void setLanguageMenu(JMenu languageMenu) {
		this.languageMenu = languageMenu;
	}


	public JMenu getFormatMenu() {
		return formatMenu;
	}


	public void setFormatMenu(JMenu formatMenu) {
		this.formatMenu = formatMenu;
	}


	public JMenu getCommandPrompt() {
		return commandPrompt;
	}


	public void setCommandPrompt(JMenu commandPrompt) {
		this.commandPrompt = commandPrompt;
	}


	public JMenuItem getItemNew() {
		return itemNew;
	}


	public void setItemNew(JMenuItem itemNew) {
		this.itemNew = itemNew;
	}


	public JMenuItem getItemNewWindow() {
		return itemNewWindow;
	}


	public void setItemNewWindow(JMenuItem itemNewWindow) {
		this.itemNewWindow = itemNewWindow;
	}


	public JMenuItem getItemOpen() {
		return itemOpen;
	}


	public void setItemOpen(JMenuItem itemOpen) {
		this.itemOpen = itemOpen;
	}


	public JMenuItem getItemSaveAs() {
		return itemSaveAs;
	}


	public void setItemSaveAs(JMenuItem itemSaveAs) {
		this.itemSaveAs = itemSaveAs;
	}


	public JMenuItem getItemSave() {
		return itemSave;
	}


	public void setItemSave(JMenuItem itemSave) {
		this.itemSave = itemSave;
	}


	public JMenuItem getItemExit() {
		return itemExit;
	}


	public void setItemExit(JMenuItem itemExit) {
		this.itemExit = itemExit;
	}


	public JMenuItem getItemWordWrap() {
		return itemWordWrap;
	}


	public void setItemWordWrap(JMenuItem itemWordWrap) {
		this.itemWordWrap = itemWordWrap;
	}


	public JMenuItem getItemFont() {
		return itemFont;
	}


	public void setItemFont(JMenuItem itemFont) {
		this.itemFont = itemFont;
	}


	public JMenuItem getItemFontSize() {
		return itemFontSize;
	}


	public void setItemFontSize(JMenuItem itemFontSize) {
		this.itemFontSize = itemFontSize;
	}


	public JMenuItem getItemCMD() {
		return itemCMD;
	}


	public void setItemCMD(JMenuItem itemCMD) {
		this.itemCMD = itemCMD;
	}


	public BufferedReader getBr() {
		return br;
	}


	public void setBr(BufferedReader br) {
		this.br = br;
	}


	public BufferedWriter getBw() {
		return bw;
	}


	public void setBw(BufferedWriter bw) {
		this.bw = bw;
	}


	public String getOpenPath() {
		return openPath;
	}


	public void setOpenPath(String openPath) {
		this.openPath = openPath;
	}


	public String getOpenFileName() {
		return openFileName;
	}


	public void setOpenFileName(String openFileName) {
		this.openFileName = openFileName;
	}


	public boolean isWrap() {
		return wrap;
	}


	public void setWrap(boolean wrap) {
		this.wrap = wrap;
	}


	public String getFontstyle() {
		return fontstyle;
	}


	public void setFontstyle(String fontstyle) {
		this.fontstyle = fontstyle;
	}


	public int getDefFontSize() {
		return defFontSize;
	}


	public void setDefFontSize(int defFontSize) {
		this.defFontSize = defFontSize;
	}


	public Font getArial() {
		return arial;
	}


	public void setArial(Font arial) {
		this.arial = arial;
	}


	public Font getNewRoman() {
		return newRoman;
	}


	public void setNewRoman(Font newRoman) {
		this.newRoman = newRoman;
	}


	public Font getConsolas() {
		return consolas;
	}


	public void setConsolas(Font consolas) {
		this.consolas = consolas;
	}


	public void createFrame() {
		frame = new JFrame("Notepad");
		frame.setSize(1200, 900);
		Image icon = Toolkit.getDefaultToolkit().getImage("C:\\Users\\dell\\OneDrive\\Desktop\\notepad.jpeg");
		frame.setIconImage(icon);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}

	public void createTextArea() {
		textArea = new JTextArea();
		textArea.setFont(new Font("Arial", Font.PLAIN, defFontSize));
		frame.add(textArea);

	}

	public void createScrollBars() {
		JScrollPane scroll = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scroll.setAlignmentX(JScrollPane.LEFT_ALIGNMENT);
		frame.add(scroll);

	}

	public void createMenuBar() {
		menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		fileMenu = new JMenu("File");
		menuBar.add(fileMenu);
		languageMenu = new JMenu("Language");
		menuBar.add(languageMenu);
		formatMenu = new JMenu("Format");
		menuBar.add(formatMenu);
		commandPrompt = new JMenu("Command Prompt");
		menuBar.add(commandPrompt);

	}

	public void createFileMenuItems() {

		itemNew = new JMenuItem("New");
		fileMenu.add(itemNew);
		itemNew.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				textArea.setText("");
				frame.setTitle("Untitled-Notepad");

				openFileName = null;
				openPath = null;

			}
		});
		itemNewWindow = new JMenuItem("New Window");
		fileMenu.add(itemNewWindow);
		itemNewWindow.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				Notepad cr = new Notepad();
				cr.frame.setTitle("untitled");

			}
		});
		itemOpen = new JMenuItem("Open");
		fileMenu.add(itemOpen);
		itemOpen.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				FileDialog fd = new FileDialog(frame, "Open", FileDialog.LOAD);
				fd.setVisible(true);
				String path = fd.getDirectory();
				String fileName = fd.getFile();
				if (fileName != null) {
					frame.setTitle(fileName);
					openPath = path;
					openFileName = fileName;
				}

				try {
					br = new BufferedReader(new FileReader(path + fileName));
					String sentence = br.readLine();
					while (sentence != null) {
						textArea.append(sentence+"\n");

						sentence = (br.readLine());
					}
				} catch (FileNotFoundException e2) {
					System.out.println("File not found");
				} catch (IOException e1) {

					System.out.println("data could not be read");

				} catch (NullPointerException e1) {

				} finally {
					try {
						br.close();
					} catch (IOException e1) {

						System.out.println("file could not be found");

					} catch (NullPointerException e1) {

					}
				}

			}
		});
		itemSave = new JMenuItem("Save");
		fileMenu.add(itemSave);
		itemSave.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (openFileName != null && openPath != null) {
					FileDialog fd = new FileDialog(frame, "Save", FileDialog.SAVE);
					fd.setVisible(true);
					writeDataToFile(openFileName, openPath);

				} else {
					FileDialog fd = new FileDialog(frame, "Save As", FileDialog.SAVE);
					fd.setVisible(true);
					String path = fd.getDirectory();
					String fileName = fd.getFile();
					if (fileName != null && path != null) {
						writeDataToFile(openFileName, openPath);

						openFileName = fileName;
						openPath = path;
						frame.setTitle(fileName);
					}

				}

			}
		});
		itemSaveAs = new JMenuItem("Save As");
		fileMenu.add(itemSaveAs);
		itemSaveAs.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				FileDialog fd = new FileDialog(frame, "Save As", FileDialog.SAVE);
				fd.setVisible(true);
				String path = fd.getDirectory();
				String fileName = fd.getFile();
				if (fileName != null && path != null) {
					writeDataToFile(fileName, path);

					openFileName = fileName;
					openPath = path;

					frame.setTitle(openFileName);
				}

			}
		});
		itemExit = new JMenuItem("Exit");
		fileMenu.add(itemExit);
		itemExit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				frame.dispose();

			}
		});
	}

	public void createFormatMenuItems() {
		itemWordWrap = new JMenuItem("Word Wrap : off");
		formatMenu.add(itemWordWrap);
		itemWordWrap.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (wrap == false) {
					wrap = true;
					itemWordWrap.setText("Word Wrap : on");
					textArea.setLineWrap(true);
					textArea.setWrapStyleWord(true);
				} else {
					itemWordWrap.setText("Word Wrap : off");
					textArea.setLineWrap(false);
					textArea.setWrapStyleWord(false);
					wrap = false;
				}

			}
		});
		itemFont = new JMenu("Font ");
		formatMenu.add(itemFont);
		JMenuItem itemArial = new JMenuItem("Arial");
		itemArial.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				setFontStyle("Arial");
			}
		});
		JMenuItem itemTimesNewRoman = new JMenuItem("Times New Roman");
		itemTimesNewRoman.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				setFontStyle("Times New Roman");
			}
		});
		JMenuItem itemConsolas = new JMenuItem("Consolas");
		itemConsolas.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				setFontStyle("Consolas");
			}
		});
		itemFont.add(itemArial);
		itemFont.add(itemTimesNewRoman);
		itemFont.add(itemConsolas);

		itemFontSize = new JMenu("Font Size");

		formatMenu.add(itemFontSize);
		JMenuItem itemSize10 = new JMenuItem("10");
		itemSize10.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				setFontSize(10);

			}
		});
		JMenuItem itemSize14 = new JMenuItem("14");
		itemSize14.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				setFontSize(14);

			}
		});
		JMenuItem itemSize18 = new JMenuItem("18");
		itemSize18.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				setFontSize(18);

			}
		});
		JMenuItem itemSize22 = new JMenuItem("22");
		itemSize22.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				setFontSize(22);

			}
		});
		JMenuItem itemSize26 = new JMenuItem("26");
		itemSize26.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				setFontSize(26);

			}
		});
		JMenuItem itemSize30 = new JMenuItem("30");
		itemSize30.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				setFontSize(30);

			}
		});
		JMenuItem itemSize34 = new JMenuItem("34");
		itemSize34.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				setFontSize(34);

			}
		});
		JMenuItem itemSize38 = new JMenuItem("38");
		itemSize38.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				setFontSize(38);

			}
		});
		JMenuItem itemSize42 = new JMenuItem("42");
		itemSize42.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				setFontSize(42);

			}
		});
		itemFontSize.add(itemSize10);
		itemFontSize.add(itemSize14);
		itemFontSize.add(itemSize18);
		itemFontSize.add(itemSize22);
		itemFontSize.add(itemSize26);
		itemFontSize.add(itemSize30);
		itemFontSize.add(itemSize34);
		itemFontSize.add(itemSize38);
		itemFontSize.add(itemSize42);
		setFontSize(defFontSize);

	}

	public void setFontSize(int size) {
		arial = new Font("Arial", Font.PLAIN, size);
		newRoman = new Font("Times New Roman", Font.PLAIN, size);
		consolas = new Font("Consolas", Font.PLAIN, size);
		setFontStyle(fontstyle);
	}

	public void setFontStyle(String font) {
		fontstyle = font;
		switch (font) {
		case "Arial":
			textArea.setFont(arial);
			break;
		case "Times New Roman":
			textArea.setFont(newRoman);
			break;
		case "Consolas":
			textArea.setFont(consolas);
			break;
		default:
			break;

		}

	}

	public void createCommandPromptItem() {
		itemCMD = new JMenuItem("Open Command Prompt");

		itemCMD.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
			
				try {
					
					System.out.println(openPath);
					if (openPath != null) {
						
						Runtime.getRuntime().exec(new String[] { "cmd", "/C", "start" }, null, new File(openPath));

					}

				} catch (IOException e1) {
					System.out.println("Could not launch cmd");
				} catch (NullPointerException e2) {

				}

			}
		});

		commandPrompt.add(itemCMD);

	}

	public void writeDataToFile(String fileName, String path) {
		openFileName = fileName;
		openPath = path;
		try {
			bw = new BufferedWriter(new FileWriter(path + fileName));
			String text = textArea.getText();
			bw.write(text);
		} catch (IOException e1) {
			System.out.println("Data Cannot be Written");
		} finally {
			try {
				bw.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			} catch (NullPointerException e1) {
				System.out.println("");
			}
		}

	}

	public void createLanguageItems() {
		JMenuItem itemJava = new JMenuItem("Java");

		itemJava.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				setLanguage("Java");
				
				
			}
		});

		languageMenu.add(itemJava);

		JMenuItem itemC = new JMenuItem("C");
		languageMenu.add(itemC);
		itemC.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				setLanguage("C");
			}
		});

		JMenuItem itemHtml = new JMenuItem("HTML");
		languageMenu.add(itemHtml);

		itemHtml.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				setLanguage("HTML");
			}
		});

		JMenuItem itemCpp = new JMenuItem("C++");
		languageMenu.add(itemCpp);

		itemCpp.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				setLanguage("Cpp");
			}
		});

		
		
	}

	public void setLanguage(String lang) {
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader("D:\\filehandle\\"+lang+"Format.txt"));
			

			String sentence = br.readLine();
			textArea.setText(null);

			while (sentence != null) {
				
				textArea.append(sentence + "\n");
				sentence = br.readLine();
			}

		} catch (FileNotFoundException e1) {
			System.out.println("File not Found");
		} catch (IOException e1) {
			System.out.println("Data  could not be read ");
		} catch (NullPointerException e2) {

		} finally {
			try {
				br.close();
			} catch (IOException e1) {
				System.out.println("File could  not be close");
			} catch (NullPointerException e2) {

			}
		}
	}

}
