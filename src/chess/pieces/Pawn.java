package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessPiece;
import chess.Color;

public class Pawn extends ChessPiece {

	public Pawn(Board board, Color color) {
		super(board, color);
	}

	@Override
	public boolean[][] possibleMoves() {
		boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];

		Position p = new Position(0, 0);
		
		//se o peão for preto, anda pra baixo, se for branco, pra cima.
		int direction = getColor() == Color.WHITE ? -1 : 1;

		//para frente
		p.setValues(position.getRow() + direction, position.getColumn());
		if(getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
			mat[p.getRow()][p.getColumn()] = true;
			
			//para frente mov inicial (duas casas)
			p.setValues(position.getRow() + (direction*2), position.getColumn());
			if(getBoard().positionExists(p) && !getBoard().thereIsAPiece(p) && getMoveCount() == 0) {
				mat[p.getRow()][p.getColumn()] = true;
			}
		}
		
		//para um lado
		p.setValues(position.getRow() + direction, position.getColumn()+1);
		if(getBoard().positionExists(p) && isThereOpponentPiece(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}
		
		//para o outro lado
		p.setValues(position.getRow() + direction, position.getColumn()-1);
		if(getBoard().positionExists(p) && isThereOpponentPiece(p)) {
			mat[p.getRow()][p.getColumn()] = true;
		}
		
		return mat;
	}

	@Override
	public String toString() {
		return "P";
	}
	
	

}
