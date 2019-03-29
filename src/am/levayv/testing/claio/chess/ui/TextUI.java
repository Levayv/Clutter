package am.levayv.testing.claio.chess.ui;

import am.levayv.testing.claio.chess.model.Model;
import am.levayv.testing.claio.chess.model.piece.data.Pos;

import java.util.ArrayList;

public class TextUI extends AbstractUI {

    private ArrayList<String> buffer;
    private TextCell[][] symbols = new TextCell[size][size];
    private ArrayList<TextCell> symbolList = new ArrayList<TextCell>();

    public TextUI(Model model) {
        super(model);
        buffer = new ArrayList<String>();
        update();
    }

    @Override
    public void processInput(Pos pos) {

    }

    @Override
    public void update() {

        buffer.clear();
        Pos pos;

        for (TextCell symbol :
                symbolList) {
            String icon = String.valueOf(symbol.getView().icon);
            buffer.add(""+icon);
        }


//        for (int i = size-1 ; i >= 0; i--) {
//            for (int j = 0; j < size; j++) {
//                pos = new Pos(i,j);
//                if (model.mask.getIsOccupied(pos)){
////                    buttons[i][j].setText(String.valueOf(model.mask.id[i][j].ordinal()));
//                    if (model.mask.getIsWhite(pos)){
//                        buffer.add(""+(String.valueOf(model.mask.getType(pos).getIcon(true))));
//                    }else{
//                        buffer.add(""+(String.valueOf(model.mask.getType(pos).getIcon(false))));
//                    }
//                }else {
//                    buffer.add("X");
//                }
//            }
//
//        }

        for (int i = 0; i < buffer.size(); i++) {
            System.out.print(buffer.get(i));
            if (i!=0)
                if (((i+1)%8)==0)
                    System.out.println();
        }
//        for (String s :
//                buffer) {
//            System.out.print(s);
//
//            System.out.println();
//        }
//        System.out.println(buffer);
    }
}
