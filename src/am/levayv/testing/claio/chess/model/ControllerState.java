package am.levayv.testing.claio.chess.model;


import am.levayv.testing.claio.chess.model.fsm.State;
import am.levayv.testing.claio.chess.model.piece.King;
import am.levayv.testing.claio.chess.model.piece.Pawn;
import am.levayv.testing.claio.chess.model.piece.data.Pos;

enum ControllerState implements State<Controller> {

    WAITING() {
        private Cell cell;

        @Override
        public void update(Controller var1) {
            // tick tack ?
        }

        @Override
        public boolean onEvent(Controller ctrl, Pos pos) {
            cell = Model.getInstance().board.
                    getCell(pos);
            if (cell.isOccupied()) {
                if (cell.isMine(ctrl.getCurrentPlayer())) {
                    if (cell.canMoveThePiece()) {
                        assert cell != null;
                        ctrl.setActiveCell(cell);
                        ctrl.setCandidateCells(cell.piece.getAvailableMoves(),true);
                        assert ctrl.getActiveCell() != null;
                        ctrl.stateMachine.changeState(MOVING);
                        // todo polish logging
                        System.out.println("Log: state changed to SELF moving");
                        return true;
                    }
                }
            }
            return false;
        }
    },

    MOVING() {
        private Cell cell;
        private Cell from;
        @Override
        public void update(Controller controller) {
            // tick tack ?
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
                ctrl.setCandidateCells(cell.piece.getAvailableMoves(),false);
                ctrl.stateMachine.changeState(WAITING);
                //todo polish logging
                System.out.println("Log: state changed to SELF wait");
                return true;
            } else {
                // IF piece can move here
                if (from.canArriveTo(cell)) {
                    if (from.getPiece().isSpecialMove(cell)){
                        // IF Special Move : Castling
                        if (from.getPiece() instanceof King){
                            System.out.println("!!! Castle from ");
                            boolean b1 = cell.moveHere(from);
                            assert b1;
                            if (((King) cell.getPiece()).isCastlingToTheRight()){
                                boolean b2 = ((King) cell.getPiece()).
                                        castling.getCellRookRightTo().moveHere(
                                        ((King) cell.getPiece()).
                                                castling.getCellRookRightFrom()
                                );
                                assert b2;
                            } else {
                                boolean b2 = ((King) cell.getPiece()).
                                        castling.getCellRookLeftTo().moveHere(
                                        ((King) cell.getPiece()).
                                                castling.getCellRookLeftFrom()
                                );
                                assert b2;
                            }
                            System.out.println("!!! Castle  to  ");
                        }
                        // IF Special Move : In passing
                        if (from.getPiece() instanceof Pawn){
                            System.out.println("IN PASSING - MISSING FUNCTIONALITY");
                        }
//                        boolean b = cell.moveHere(from);
//                        assert b;
                    }else {
                        boolean b = cell.moveHere(from); //todo refactor , boolean b not needed
                        assert b;
                    }
                    ctrl.setActiveCell(null);
                    ctrl.setCandidateCells(cell.piece.getAvailableMoves(),false);
                    ctrl.switchPlayer();
                    //////////////////


                    ///////////////////
                    ctrl.stateMachine.changeState(WAITING);
                    //todo polish logging
                    System.out.println("Log: state changed to OPPONENT wait");
                    System.out.println("Log: player changed");
                    return true;
                } else { // abort movement
                    ctrl.setActiveCell(null);
                    ctrl.setCandidateCells(from.piece.getAvailableMoves(),false);
                    ctrl.stateMachine.changeState(WAITING);
                    //todo polish logging
                    System.out.println("Log: state changed to SELF wait");
                    return false;
                }
            }
        }
    }
}
