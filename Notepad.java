package Notepad;

// Import necessary packages for GUI components, file handling, and events
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
    // Declare components for the notepad application
    private JFrame frame; // Main frame of the notepad
    private JTextArea textArea; // Text area for editing content
    private JMenuBar menuBar; // Menu bar for menu items
    private JMenu fileMenu, languageMenu, formatMenu, commandPrompt; // Menus for different functionalities

    // File menu items for creating, opening, saving, and exiting
    private JMenuItem itemNew, itemNewWindow, itemOpen, itemSaveAs, itemSave, itemExit;

    // Format menu items for text formatting options
    private JMenuItem itemWordWrap, itemFont, itemFontSize;

    // Command prompt menu item
    private JMenuItem itemCMD;

    // Buffered readers and writers for file I/O
    private BufferedReader br = null;
    private BufferedWriter bw = null;

    // Variables to store file path and name for opened files
    private String openPath = null;
    private String openFileName = null;

    // Flag for word wrap functionality
    private boolean wrap = false;

    // Default font style and size
    private String fontstyle = "Arial";
    private int defFontSize = 34;

    // Font objects for different font styles
    private Font arial, newRoman, consolas;

    // Constructor for the Notepad class
    public Notepad() {
        // Initialize components and set up the GUI
        createFrame(); // Create the main frame
        createTextArea(); // Create the text area for editing
        createScrollBars(); // Add scrollbars to the text area
        createMenuBar(); // Create the menu bar
        createFileMenuItems(); // Add items to the File menu
        createFormatMenuItems(); // Add items to the Format menu
        createCommandPromptItem(); // Add item for command prompt functionality
        createLanguageItems(); // Add items for language selection (if implemented)
    }

    // Getter for the main frame
    public JFrame getFrame() {
        return frame;
    }



 // Setter for the main frame
    public void setFrame(JFrame frame) {
        this.frame = frame;
    }

    // Getter for the text area
    public JTextArea getTextArea() {
        return textArea;
    }

    // Setter for the text area
    public void setTextArea(JTextArea textArea) {
        this.textArea = textArea;
    }

    // Getter for the menu bar
    public JMenuBar getMenuBar() {
        return menuBar;
    }

    // Setter for the menu bar
    public void setMenuBar(JMenuBar menuBar) {
        this.menuBar = menuBar;
    }

    // Getter for the File menu
    public JMenu getFileMenu() {
        return fileMenu;
    }

    // Setter for the File menu
    public void setFileMenu(JMenu fileMenu) {
        this.fileMenu = fileMenu;
    }

    // Getter for the Language menu
    public JMenu getLanguageMenu() {
        return languageMenu;
    }

    // Setter for the Language menu
    public void setLanguageMenu(JMenu languageMenu) {
        this.languageMenu = languageMenu;
    }

    // Getter for the Format menu
    public JMenu getFormatMenu() {
        return formatMenu;
    }

    // Setter for the Format menu
    public void setFormatMenu(JMenu formatMenu) {
        this.formatMenu = formatMenu;
    }

    // Getter for the Command Prompt menu
    public JMenu getCommandPrompt() {
        return commandPrompt;
    }

    // Setter for the Command Prompt menu
    public void setCommandPrompt(JMenu commandPrompt) {
        this.commandPrompt = commandPrompt;
    }

    // Getter for the "New" menu item
    public JMenuItem getItemNew() {
        return itemNew;
    }

    // Setter for the "New" menu item
    public void setItemNew(JMenuItem itemNew) {
        this.itemNew = itemNew;
    }

    // Getter for the "New Window" menu item
    public JMenuItem getItemNewWindow() {
        return itemNewWindow;
    }

    // Setter for the "New Window" menu item
    public void setItemNewWindow(JMenuItem itemNewWindow) {
        this.itemNewWindow = itemNewWindow;
    }

    // Getter for the "Open" menu item
    public JMenuItem getItemOpen() {
        return itemOpen;
    }

    // Setter for the "Open" menu item
    public void setItemOpen(JMenuItem itemOpen) {
        this.itemOpen = itemOpen;
    }

    // Getter for the "Save As" menu item
    public JMenuItem getItemSaveAs() {
        return itemSaveAs;
    }

    // Setter for the "Save As" menu item
    public void setItemSaveAs(JMenuItem itemSaveAs) {
        this.itemSaveAs = itemSaveAs;
    }

    // Getter for the "Save" menu item
    public JMenuItem getItemSave() {
        return itemSave;
    }

    // Setter for the "Save" menu item
    public void setItemSave(JMenuItem itemSave) {
        this.itemSave = itemSave;
    }

    // Getter for the "Exit" menu item
    public JMenuItem getItemExit() {
        return itemExit;
    }

    // Setter for the "Exit" menu item
    public void setItemExit(JMenuItem itemExit) {
        this.itemExit = itemExit;
    }

    // Getter for the "Word Wrap" menu item
    public JMenuItem getItemWordWrap() {
        return itemWordWrap;
    }

    // Setter for the "Word Wrap" menu item
    public void setItemWordWrap(JMenuItem itemWordWrap) {
        this.itemWordWrap = itemWordWrap;
    }

    // Getter for the "Font" menu item
    public JMenuItem getItemFont() {
        return itemFont;
    }

    // Setter for the "Font" menu item
    public void setItemFont(JMenuItem itemFont) {
        this.itemFont = itemFont;
    }

    // Getter for the "Font Size" menu item
    public JMenuItem getItemFontSize() {
        return itemFontSize;
    }

    // Setter for the "Font Size" menu item
    public void setItemFontSize(JMenuItem itemFontSize) {
        this.itemFontSize = itemFontSize;
    }

    // Getter for the "Command Prompt" menu item
    public JMenuItem getItemCMD() {
        return itemCMD;
    }

    // Setter for the "Command Prompt" menu item
    public void setItemCMD(JMenuItem itemCMD) {
        this.itemCMD = itemCMD;
    }

    // Getter for the BufferedReader object
    public BufferedReader getBr() {
        return br;
    }

    // Setter for the BufferedReader object
    public void setBr(BufferedReader br) {
        this.br = br;
    }

    // Getter for the BufferedWriter object
    public BufferedWriter getBw() {
        return bw;
    }

    // Setter for the BufferedWriter object
    public void setBw(BufferedWriter bw) {
        this.bw = bw;
    }

    // Getter for the file open path
    public String getOpenPath() {
        return openPath;
    }

    // Setter for the file open path
    public void setOpenPath(String openPath) {
        this.openPath = openPath;
    }

    // Getter for the open file name
    public String getOpenFileName() {
        return openFileName;
    }

    // Setter for the open file name
    public void setOpenFileName(String openFileName) {
        this.openFileName = openFileName;
    }

    // Getter for the word wrap flag
    public boolean isWrap() {
        return wrap;
    }

    // Setter for the word wrap flag
    public void setWrap(boolean wrap) {
        this.wrap = wrap;
    }

    // Getter for the font style
    public String getFontstyle() {
        return fontstyle;
    }

    // Setter for the font style
    public void setFontstyle(String fontstyle) {
        this.fontstyle = fontstyle;
    }

    // Getter for the default font size
    public int getDefFontSize() {
        return defFontSize;
    }

    // Setter for the default font size
    public void setDefFontSize(int defFontSize) {
        this.defFontSize = defFontSize;
    }

    // Getter for the Arial font object
    public Font getArial() {
        return arial;
    }

    // Setter for the Arial font object
    public void setArial(Font arial) {
        this.arial = arial;
    }

    // Getter for the New Roman font object
    public Font getNewRoman() {
        return newRoman;
    }

    // Setter for the New Roman font object
    public void setNewRoman(Font newRoman) {
        this.newRoman = newRoman;
    }

    // Getter for the Consolas font object
    public Font getConsolas() {
        return consolas;
    }

    // Setter for the Consolas font object
    public void setConsolas(Font consolas) {
        this.consolas = consolas;
    }

 // Method to create and configure the main frame
    public void createFrame() {
        frame = new JFrame("Notepad"); // Create a new JFrame with the title "Notepad"
        frame.setSize(1200, 900); // Set the frame's dimensions
        Image icon = Toolkit.getDefaultToolkit().getImage("C:\\Users\\dell\\OneDrive\\Desktop\\notepad.jpeg"); // Load an image to use as the icon
        frame.setIconImage(icon); // Set the frame's icon
        frame.setVisible(true); // Make the frame visible
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Close only this frame when the user exits
    }

    // Method to create a text area and add it to the frame
    public void createTextArea() {
        textArea = new JTextArea(); // Create a new text area
        textArea.setFont(new Font("Arial", Font.PLAIN, defFontSize)); // Set the font for the text area
        frame.add(textArea); // Add the text area directly to the frame
    }

    // Method to create scroll bars for the text area
    public void createScrollBars() {
        JScrollPane scroll = new JScrollPane(
            textArea, // Target the text area for scrolling
            JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, // Vertical scroll bar appears as needed
            JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED // Horizontal scroll bar appears as needed
        );
        scroll.setAlignmentX(JScrollPane.LEFT_ALIGNMENT); // Align the scroll pane to the left
        frame.add(scroll); // Add the scroll pane to the frame
    }

    // Method to create a menu bar and add menus to it
    public void createMenuBar() {
        menuBar = new JMenuBar(); // Create a new menu bar
        frame.setJMenuBar(menuBar); // Set the menu bar for the frame

        fileMenu = new JMenu("File"); // Create the "File" menu
        menuBar.add(fileMenu); // Add the "File" menu to the menu bar

        languageMenu = new JMenu("Language"); // Create the "Language" menu
        menuBar.add(languageMenu); // Add the "Language" menu to the menu bar

        formatMenu = new JMenu("Format"); // Create the "Format" menu
        menuBar.add(formatMenu); // Add the "Format" menu to the menu bar

        commandPrompt = new JMenu("Command Prompt"); // Create the "Command Prompt" menu
        menuBar.add(commandPrompt); // Add the "Command Prompt" menu to the menu bar
    }
    public void createFileMenuItems() {

        // Create "New" menu item and add it to the File menu
        itemNew = new JMenuItem("New");
        fileMenu.add(itemNew);

        // Add action listener for "New" menu item
        itemNew.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Clear the text area and reset the title
                textArea.setText("");
                frame.setTitle("Untitled-Notepad");

                // Reset file name and path to null
                openFileName = null;
                openPath = null;
            }
        });

        // Create "New Window" menu item and add it to the File menu
        itemNewWindow = new JMenuItem("New Window");
        fileMenu.add(itemNewWindow);

        // Add action listener for "New Window" menu item
        itemNewWindow.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Open a new instance of the Notepad application
                Notepad cr = new Notepad();
                cr.frame.setTitle("untitled");
            }
        });

        // Create "Open" menu item and add it to the File menu
        itemOpen = new JMenuItem("Open");
        fileMenu.add(itemOpen);

        // Add action listener for "Open" menu item
        itemOpen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Open file dialog to select a file
                FileDialog fd = new FileDialog(frame, "Open", FileDialog.LOAD);
                fd.setVisible(true);
                String path = fd.getDirectory();
                String fileName = fd.getFile();

                // Check if a file was selected
                if (fileName != null) {
                    frame.setTitle(fileName); // Set the frame title to the file name
                    openPath = path;         // Save the file path
                    openFileName = fileName; // Save the file name
                }

                try {
                    // Read the file line by line and display it in the text area
                    br = new BufferedReader(new FileReader(path + fileName));
                    String sentence = br.readLine();
                    while (sentence != null) {
                        textArea.append(sentence + "\n");
                        sentence = br.readLine();
                    }
                } catch (FileNotFoundException e2) {
                    System.out.println("File not found");
                } catch (IOException e1) {
                    System.out.println("Data could not be read");
                } catch (NullPointerException e1) {
                    // Handle case where no file is selected
                } finally {
                    try {
                        // Close the buffered reader
                        br.close();
                    } catch (IOException e1) {
                        System.out.println("File could not be closed");
                    } catch (NullPointerException e1) {
                        // Handle case where buffered reader is null
                    }
                }
            }
        });

        // Create "Save" menu item and add it to the File menu
        itemSave = new JMenuItem("Save");
        fileMenu.add(itemSave);

        // Add action listener for "Save" menu item
        itemSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // If a file is already opened, save changes to it
                if (openFileName != null && openPath != null) {
                    writeDataToFile(openFileName, openPath);
                } else {
                    // If no file is opened, prompt "Save As" dialog
                    FileDialog fd = new FileDialog(frame, "Save As", FileDialog.SAVE);
                    fd.setVisible(true);
                    String path = fd.getDirectory();
                    String fileName = fd.getFile();
                    if (fileName != null && path != null) {
                        writeDataToFile(fileName, path);
                        openFileName = fileName; // Update the file name
                        openPath = path;         // Update the file path
                        frame.setTitle(fileName); // Update the frame title
                    }
                }
            }
        });

        // Create "Save As" menu item and add it to the File menu
        itemSaveAs = new JMenuItem("Save As");
        fileMenu.add(itemSaveAs);

        // Add action listener for "Save As" menu item
        itemSaveAs.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Prompt user with "Save As" dialog
                FileDialog fd = new FileDialog(frame, "Save As", FileDialog.SAVE);
                fd.setVisible(true);
                String path = fd.getDirectory();
                String fileName = fd.getFile();
                if (fileName != null && path != null) {
                    writeDataToFile(fileName, path);
                    openFileName = fileName; // Save the file name
                    openPath = path;         // Save the file path
                    frame.setTitle(openFileName); // Update the frame title
                }
            }
        });

        // Create "Exit" menu item and add it to the File menu
        itemExit = new JMenuItem("Exit");
        fileMenu.add(itemExit);

        // Add action listener for "Exit" menu item
        itemExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Close the application window
                frame.dispose();
            }
        });
    }

    public void createFormatMenuItems() {
        // Create the Word Wrap menu item with default state as "off"
        itemWordWrap = new JMenuItem("Word Wrap : off");
        formatMenu.add(itemWordWrap);
        itemWordWrap.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // Toggle Word Wrap functionality
                if (wrap == false) {
                    wrap = true;
                    itemWordWrap.setText("Word Wrap : on"); // Update menu item text to "on"
                    textArea.setLineWrap(true);             // Enable line wrapping
                    textArea.setWrapStyleWord(true);        // Enable wrapping at word boundaries
                } else {
                    itemWordWrap.setText("Word Wrap : off"); // Update menu item text to "off"
                    textArea.setLineWrap(false);             // Disable line wrapping
                    textArea.setWrapStyleWord(false);        // Disable wrapping at word boundaries
                    wrap = false;
                }
            }
        });

        // Create a Font menu to hold font style options
        itemFont = new JMenu("Font ");
        formatMenu.add(itemFont);

        // Add Arial font option
        JMenuItem itemArial = new JMenuItem("Arial");
        itemArial.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setFontStyle("Arial"); // Set text area font to Arial
            }
        });

        // Add Times New Roman font option
        JMenuItem itemTimesNewRoman = new JMenuItem("Times New Roman");
        itemTimesNewRoman.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setFontStyle("Times New Roman"); // Set text area font to Times New Roman
            }
        });

        // Add Consolas font option
        JMenuItem itemConsolas = new JMenuItem("Consolas");
        itemConsolas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setFontStyle("Consolas"); // Set text area font to Consolas
            }
        });

        // Add font options to the Font menu
        itemFont.add(itemArial);
        itemFont.add(itemTimesNewRoman);
        itemFont.add(itemConsolas);

        // Create a Font Size menu to hold font size options
        itemFontSize = new JMenu("Font Size");
        formatMenu.add(itemFontSize);

        // Add font size options
        JMenuItem itemSize10 = new JMenuItem("10");
        itemSize10.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setFontSize(10); // Set font size to 10
            }
        });
        JMenuItem itemSize14 = new JMenuItem("14");
        itemSize14.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setFontSize(14); // Set font size to 14
            }
        });
        JMenuItem itemSize18 = new JMenuItem("18");
        itemSize18.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setFontSize(18); // Set font size to 18
            }
        });
        JMenuItem itemSize22 = new JMenuItem("22");
        itemSize22.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setFontSize(22); // Set font size to 22
            }
        });
        JMenuItem itemSize26 = new JMenuItem("26");
        itemSize26.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setFontSize(26); // Set font size to 26
            }
        });
        JMenuItem itemSize30 = new JMenuItem("30");
        itemSize30.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setFontSize(30); // Set font size to 30
            }
        });
        JMenuItem itemSize34 = new JMenuItem("34");
        itemSize34.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setFontSize(34); // Set font size to 34
            }
        });
        JMenuItem itemSize38 = new JMenuItem("38");
        itemSize38.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setFontSize(38); // Set font size to 38
            }
        });
        JMenuItem itemSize42 = new JMenuItem("42");
        itemSize42.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setFontSize(42); // Set font size to 42
            }
        });

        // Add font size options to the Font Size menu
        itemFontSize.add(itemSize10);
        itemFontSize.add(itemSize14);
        itemFontSize.add(itemSize18);
        itemFontSize.add(itemSize22);
        itemFontSize.add(itemSize26);
        itemFontSize.add(itemSize30);
        itemFontSize.add(itemSize34);
        itemFontSize.add(itemSize38);
        itemFontSize.add(itemSize42);

        // Set default font size at the start
        setFontSize(defFontSize);
    }

    // Method to set the font size and update all font styles
    public void setFontSize(int size) {
        arial = new Font("Arial", Font.PLAIN, size); // Set Arial font size
        newRoman = new Font("Times New Roman", Font.PLAIN, size); // Set Times New Roman font size
        consolas = new Font("Consolas", Font.PLAIN, size); // Set Consolas font size
        setFontStyle(fontstyle); // Apply the current font style with the new size
    }

    // Method to apply the selected font style to the text area
    public void setFontStyle(String font) {
        fontstyle = font; // Store the current font style
        switch (font) {
            case "Arial":
                textArea.setFont(arial); // Apply Arial font
                break;
            case "Times New Roman":
                textArea.setFont(newRoman); // Apply Times New Roman font
                break;
            case "Consolas":
                textArea.setFont(consolas); // Apply Consolas font
                break;
            default:
                break; // Do nothing for undefined font styles
        }
    }

    public void createCommandPromptItem() {
        // Create a menu item to open the Command Prompt
        itemCMD = new JMenuItem("Open Command Prompt");

        itemCMD.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    // Print the path to the console for debugging purposes
                    System.out.println(openPath);
                    if (openPath != null) {
                        // Launch Command Prompt with the specified path as the working directory
                        Runtime.getRuntime().exec(new String[] { "cmd", "/C", "start" }, null, new File(openPath));
                    }
                } catch (IOException e1) {
                    // Handle errors when attempting to launch the Command Prompt
                    System.out.println("Could not launch cmd");
                } catch (NullPointerException e2) {
                    // Handle null pointer exceptions silently
                }
            }
        });

        // Add the menu item to the Command Prompt menu
        commandPrompt.add(itemCMD);
    }

    public void writeDataToFile(String fileName, String path) {
        // Set the current file name and path
        openFileName = fileName;
        openPath = path;

        try {
            // Create a BufferedWriter to write data to the specified file
            bw = new BufferedWriter(new FileWriter(path + fileName));
            String text = textArea.getText(); // Get text from the text area
            bw.write(text); // Write the text to the file
        } catch (IOException e1) {
            // Handle errors during file writing
            System.out.println("Data Cannot be Written");
        } finally {
            try {
                // Close the BufferedWriter to release resources
                bw.close();
            } catch (IOException e1) {
                // Handle errors when closing the BufferedWriter
                e1.printStackTrace();
            } catch (NullPointerException e1) {
                // Handle null pointer exceptions silently
                System.out.println("");
            }
        }
    }

    public void createLanguageItems() {
        // Create a menu item for Java language
        JMenuItem itemJava = new JMenuItem("Java");

        itemJava.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // Set the selected language to Java
                setLanguage("Java");
            }
        });

        // Add the Java menu item to the Language menu
        languageMenu.add(itemJava);

        // Create and add a menu item for the C language
        JMenuItem itemC = new JMenuItem("C");
        languageMenu.add(itemC);
        itemC.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // Set the selected language to C
                setLanguage("C");
            }
        });

        // Create and add a menu item for the HTML language
        JMenuItem itemHtml = new JMenuItem("HTML");
        languageMenu.add(itemHtml);

        itemHtml.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // Set the selected language to HTML
                setLanguage("HTML");
            }
        });

        // Create and add a menu item for the C++ language
        JMenuItem itemCpp = new JMenuItem("C++");
        languageMenu.add(itemCpp);

        itemCpp.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // Set the selected language to C++
                setLanguage("Cpp");
            }
        });
    }
    public void setLanguage(String lang) {
        // Declare a BufferedReader to read from the file
        BufferedReader br = null;
        try {
            // Try to open the file corresponding to the selected language
            br = new BufferedReader(new FileReader("D:\\filehandle\\" + lang + "Format.txt"));

            String sentence = br.readLine(); // Read the first line of the file
            textArea.setText(null); // Clear the text area before adding new content

            // Loop through the file and append each line to the text area
            while (sentence != null) {
                textArea.append(sentence + "\n"); // Add the sentence to the text area with a newline
                sentence = br.readLine(); // Read the next line
            }

        } catch (FileNotFoundException e1) {
            // Handle case where the specified file is not found
            System.out.println("File not Found");
        } catch (IOException e1) {
            // Handle any errors that occur while reading the file
            System.out.println("Data  could not be read ");
        } catch (NullPointerException e2) {
            // Handle NullPointerExceptions silently (if any)
        } finally {
            try {
                // Close the BufferedReader to release resources
                if (br != null) {
                    br.close();
                }
            } catch (IOException e1) {
                // Handle errors that occur while closing the BufferedReader
                System.out.println("File could  not be close");
            } catch (NullPointerException e2) {
                // Handle NullPointerExceptions silently (if any)
            }
        }
    }

}
