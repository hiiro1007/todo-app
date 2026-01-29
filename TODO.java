import javax.swing.*;
import java.awt.*;

public class TODO {
    public static void main(String[] args) {
		
    	
    	// フレーム
        var fr = new JFrame();
        fr.setTitle("TODO");
        fr.setSize(420, 360);
    	fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	fr.setLayout(null);
    	
    	
    	//タイトル
    	JLabel title = new JLabel("TODO リスト");
    	
    	title.setBounds(0, 10, 400, 40);  // 位置とサイズ
		title.setHorizontalAlignment(JLabel.CENTER); // 中央寄せ
    	
    	
    	Font titleFont = new Font("Meiryo UI", Font.BOLD, 20);  //フォントを大きくする
		title.setFont(titleFont);
    	fr.add(title);
    	
    	
    	
    	// テキスト入力
    	JTextField txt = new JTextField();
    	txt.setBounds(10,60,200,30);
    	fr.add(txt);
    	
    	
    	// 追加ボタン
    	JButton btn = new JButton("追加");
    	btn.setBounds(220,60,80,30);
    	fr.add(btn);
    	
    	
    	// TODO表示エリア
    	DefaultListModel<String> model = new DefaultListModel<>();
    	JList<String> list = new JList<>(model);
    	
    	JScrollPane scroll = new JScrollPane(list);
    	scroll.setBounds(10,110,380,200);
    	fr.add(scroll);
    	
    	
    	// 追加ボタンを押したとき
    	btn.addActionListener(e -> {
            String text = txt.getText();
    		
            if (!text.isEmpty()) {
                model.addElement(text);
                txt.setText("");
            }
        });
    	//Enterでも同じ処理
    	txt.addActionListener(e -> btn.doClick());
    	
    	
    	//削除ボタン
    	JButton del = new JButton("削除");
    	del.setBounds(310,60,80,30);
    	fr.add(del);
    	
    	
    	//削除ボタンを押したとき
    	del.addActionListener(e -> {
    		int index = list.getSelectedIndex();
    		
    		if (index != -1) {
    			
    			int result = JOptionPane.showConfirmDialog(
    				fr,
    				"選択したTODOを削除しますか？",
    				"確認",
    				JOptionPane.YES_NO_OPTION
    			);
    			
    			if (result == JOptionPane.YES_OPTION){
    				model.remove(index);
    			}
    		}
    	});
    	
    	
    	Font font = new Font("Meiryo UI",Font.PLAIN,14);
    	
    	txt.setFont(font);
    	btn.setFont(font);
    	del.setFont(font);
    	list.setFont(font);
    	
    	
    						//カラー
    	
    	//背景色
    	fr.getContentPane().setBackground(new Color(230, 240, 250));
    	
    	
    	//タイトル
    	title.setForeground(new Color(80, 120, 160));
    	
    	
    	
    	//入力欄
    	txt.setBackground(new Color(235, 242, 250));
		txt.setForeground(Color.BLACK);
    	
    	
    	//追加ボタン
    	btn.setBackground(new Color(200, 220, 245));
		btn.setForeground(Color.BLACK);
    	
    	
    	//削除ボタン
    	del.setBackground(new Color(235, 200, 200));
		del.setForeground(Color.BLACK);
    	
    	
    	//TODO一覧
    	list.setBackground(Color.WHITE);
		list.setSelectionBackground(new Color(210, 225, 245));
		list.setSelectionForeground(Color.BLACK);

		scroll.getViewport().setBackground(Color.WHITE);
    	
    	
    	
    	
    	
    	fr.setVisible(true);
    }
}

    	