package ru.vsu.cs.aisd2021.g72.kovalenko_v_yu;

import ru.vsu.cs.util.ArrayUtils;
import ru.vsu.cs.util.DrawUtils;
import ru.vsu.cs.util.JTableUtils;
import ru.vsu.cs.util.SwingUtils;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;

public class FrameMain extends JFrame {
    private JTable gameTable;
    private JButton buttonBegin;
    private JTextField textCount;
    private JLabel numberOfPersuation;
    private JPanel panel1;
    private JButton buttonNext;

    private static final Color[] COLORS = {
            Color.WHITE,
            Color.BLACK
    };

    private static final int DEFAULT_CELL_SIZE = 50;
    private int n;
    private int[][] map = {{0}};
    private int term = 0;
    private boolean last = false;

    public FrameMain() {


        this.setTitle("Ферзи");
        this.setContentPane(panel1);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        this.pack();

        JTableUtils.initJTableForArray(gameTable, DEFAULT_CELL_SIZE, false, false, false, false);
        gameTable.setRowHeight(DEFAULT_CELL_SIZE);


        gameTable.setIntercellSpacing(new Dimension(0, 0));
        gameTable.setEnabled(false);

        gameTable.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
            final class DrawComponent extends Component {
                private int row = 0, column = 0;

                @Override
                public void paint(Graphics gr) {
                    Graphics2D g2d = (Graphics2D) gr;
                    try {
                        paintCell(row, column, g2d);
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                }
            }

            final DrawComponent comp = new DrawComponent();

            @Override
            public Component getTableCellRendererComponent(JTable table, Object value,
                                                           boolean isSelected, boolean hasFocus, int row, int column) {
                comp.row = row;
                comp.column = column;
                return comp;
            }
        });

        newProgram();

        updateView();


    }

    private void updateView() {
        gameTable.repaint();
    }

    private static Image q;

    static {
        try {
            q = ImageIO.read(new File("./queen.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private void paintCell(int row, int column, Graphics2D g2d) throws ParseException {
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        int size = DEFAULT_CELL_SIZE;
        int bound = (int) Math.round(size * 2);

        int cellValue = map[row][column];

        if (cellValue == 0) {
            g2d.setColor(Color.WHITE);
        } else {
            g2d.drawImage(q, 0, 0, 50, 50, null);
        }


    }

    private void newProgram() {
        buttonBegin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    term=0;
                    n = Integer.parseInt(textCount.getText());
                    Logic.clear();
                    Logic.permutation(n);
                    map = Logic.toArray(n);
                    numberOfPersuation.setText("Перестановка № " + ++term);
                    JTableUtils.writeArrayToJTable(gameTable, map);
                } catch (Exception e) {
                    SwingUtils.showErrorMessageBox(e);
                }
            }
        });
        buttonNext.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    last = !Logic.permutation(n);
                    if (!last) {

                        map = Logic.toArray(n);
                        numberOfPersuation.setText("Перестановка № " + ++term);
                        JTableUtils.writeArrayToJTable(gameTable, map);

                    }
                } catch (Exception e) {
                    SwingUtils.showErrorMessageBox(e);
                }
            }
        });
    }
}
