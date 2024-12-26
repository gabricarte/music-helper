package personal.project.view;

import personal.project.controller.MusicController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Frame extends JFrame {
    private MusicController controller;
    private JButton noteBtn;
    private JButton chordBtn;
    private JLabel noteResultLabel;
    private JLabel chordResultLabel;

    public Frame(MusicController controller) {
        this.controller = controller;
        initialize();
    }

    public MusicController getController() {
        return this.controller;
    }

    public void initialize() {
        setScreen();
        setComponents();
        setKeyListener(); // Adicionar o KeyListener
        setFocusable(true);  // Garantir que o Frame seja focável
        requestFocusInWindow(); // Solicitar o foco para o Frame
        addControllerListeners();
    }

    public void setScreen() {
        setTitle("Music Helper");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout()); // Usando BorderLayout
        setPreferredSize(new Dimension(900, 700)); // Ajustar o tamanho para um valor apropriado
        setVisible(true);
    }

    public void setComponents() {
        // Texto de explicação
        JLabel instructions = new JLabel("<html><font color='blue'>Press 'Right Arrow' to generate a random note, 'Left Arrow' to generate a random chord and 'Esc' To Exit. </font></html>", JLabel.CENTER);
        instructions.setFont(new Font("Dialog", Font.PLAIN, 14));
        add(instructions, BorderLayout.NORTH);

        // Painel central com GridBagLayout
        JPanel centerPanel = new JPanel(new GridBagLayout());
        centerPanel.setBorder(BorderFactory.createEmptyBorder(100, 80, 100, 80)); // Adiciona margem ao painel central
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.anchor = GridBagConstraints.PAGE_START;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1.0;

        // Título
        gbc.gridy = 0;
        JLabel title = new JLabel("Welcome to the music helper.", JLabel.CENTER);
        title.setFont(new Font("Dialog", Font.BOLD, 24));
        centerPanel.add(title, gbc);

        // Subtítulo
        gbc.gridy = 1;
        JLabel subtitle = new JLabel("Here, you can generate a random note or chord to practice", JLabel.CENTER);
        subtitle.setFont(new Font("Dialog", Font.BOLD, 15));
        centerPanel.add(subtitle, gbc);

        // Painel de botões
        gbc.gridy = 2;
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));

        noteBtn = new JButton("Generate a random note");
        noteBtn.setAlignmentX(Component.CENTER_ALIGNMENT);
        buttonPanel.add(noteBtn);

        buttonPanel.add(Box.createRigidArea(new Dimension(0, 10)));

        chordBtn = new JButton("Generate a random chord");
        chordBtn.setAlignmentX(Component.CENTER_ALIGNMENT);
        buttonPanel.add(chordBtn);

        centerPanel.add(buttonPanel, gbc);

        // Labels de resultado
        gbc.gridy = 3;
        noteResultLabel = new JLabel(" ", JLabel.CENTER);
        noteResultLabel.setFont(new Font("Dialog", Font.BOLD, 50));
        centerPanel.add(noteResultLabel, gbc);

        gbc.gridy = 4; // Posiciona o label do acorde
        chordResultLabel = new JLabel(" ", JLabel.CENTER);
        chordResultLabel.setFont(new Font("Dialog", Font.BOLD, 50));
        centerPanel.add(chordResultLabel, gbc);

        // Adicionar o painel central ao centro do BorderLayout
        add(centerPanel, BorderLayout.CENTER);

        // Ajustar automaticamente o tamanho da janela
        pack();

        // Iniciar no centro
        setLocationRelativeTo(null);
    }

    private void addControllerListeners() {
        if (this.controller != null) {
            noteBtn.addActionListener(e -> {
                controller.handleGenerateNoteClick();
                chordResultLabel.setText(" "); // Limpar o label do acorde
                requestFocusInWindow(); // Garantir que o frame continue com foco após clicar no botão
            });
            chordBtn.addActionListener(e -> {
                controller.handleGenerateChordNoteClick();
                noteResultLabel.setText(" "); // Limpar o label da nota
                requestFocusInWindow(); // Garantir que o frame continue com foco após clicar no botão
            });
        }
    }

    private void setKeyListener() {
        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
                    System.exit(0); // Fechar o programa quando 'Esc' for pressionado
                } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                    chordBtn.doClick(); // Acionar o botão de gerar nota quando a seta para a direita for pressionada
                } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                    noteBtn.doClick(); // Acionar o botão de gerar acorde quando a seta para a esquerda for pressionada
                }
            }
        });
        this.setFocusable(true); // Tornar o frame focável para receber eventos de teclado
        this.requestFocusInWindow(); // Solicitar foco para o frame
    }

    public void showGeneratedNoteResult(String note) {
        noteResultLabel.setText(note);
    }

    public void showGeneratedChordResult(String chord) {
        chordResultLabel.setText(chord);
    }
}
