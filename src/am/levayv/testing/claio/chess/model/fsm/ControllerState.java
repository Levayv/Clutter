package am.levayv.testing.claio.chess.model.fsm;


import am.levayv.testing.claio.chess.model.Cell;
import am.levayv.testing.claio.chess.model.Model;
import am.levayv.testing.claio.chess.model.piece.data.Pos;

public enum ControllerState implements State<Controller> {

    WHITE_WAIT() { //todo consider refactoring 1. WAITING 2. MOVING
        //        private Model model;
        private Cell cell;

        @Override
        public void update(Controller var1) {
            // tick tack
        }

        @Override
        public boolean onEvent(Controller ctrl, Pos pos) {
            cell = Model.getInstance().board.
                    getCell(pos);
            if (cell.isOccupied()) {
                if (cell.isMine(ctrl.getOwner())) {
                    if (cell.canMoveThePiece()) {
                        assert cell != null;
                        ctrl.setActiveCell(cell);
                        assert ctrl.getActiveCell() != null;
                        ctrl.stateMachine.changeState(WHITE_MOVING);
                        // todo polish logging
                        System.out.println("Log: state changed to WHITE_MOVING");
                        return true;
                    }
                }
            }
            return false;
        }

    },
    WHITE_MOVING() {
        private Cell cell;
        private Cell from;

        @Override
        public void update(Controller controller) {

        }

        @Override
        public boolean onEvent(Controller ctrl, Pos pos) {
            cell = Model.getInstance().board
                    .getCell(pos);
            from = ctrl.getActiveCell();
            assert from != null;
            // IF clicked on same cell , abort movement
            if (cell.equals(from)) {
                ctrl.setActiveCell(null);
                ctrl.stateMachine.changeState(WHITE_WAIT);
                //todo polish logging
                System.out.println("Log: state changed to WHITE_WAIT");
                return true;
            } else {
                // IF piece can move here
                if (from.canArriveTo(cell)) {
                    boolean b = cell.moveHere(from);
                    System.out.println("!!! bbb "+((b)?"moved":"notMoved"));
                    ctrl.setActiveCell(null);
                    ctrl.stateMachine.changeState(BLACK_WAIT);
                    //todo polish logging
                    System.out.println("Log: state changed to BLACK_WAIT");
                    return true;
                } else { // abort movement
                    ctrl.setActiveCell(null);
                    ctrl.stateMachine.changeState(WHITE_WAIT);
                    return false;
                }
            }
//            if (!cell.isOccupied()) { //todo bug ?
//                if (cell.canArriveHere()){
//                    from = ctrl.getActiveCell();
//                    cell.moveHere(from);
//                    //todo IMF capture
//                    // todo IMF move piece
//                    ctrl.stateMachine.changeState(WHITE_WAIT);
//                    // todo polish logging
//                    return true;
//                }
//            }
//            ctrl.setActiveCell(null);
//            return false;
        }

    },
    BLACK_WAIT() {
        @Override
        public void update(Controller controller) {

        }

        @Override
        public boolean onEvent(Controller var, Pos pos) {
            return false;
        }


    },

    BLACK_MOVING() {
        @Override
        public void update(Controller controller) {

        }

        @Override
        public boolean onEvent(Controller var, Pos pos) {
            return false;
        }

    }


}
