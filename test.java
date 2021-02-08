package test_queen;

public class test {
	 static boolean board = new boolean[8][8];
	 
	 static{
	  for(int i = 0; i < 8; i++){
	   for(int j = 0; j < 8; j++){
	    board[i][j] = false;
	   }
	  }
	 }
	 
	 // (x,y)にクイーンをおけるかどうかチェックするメソッド
	 public static boolean check(int x, int y){
	  // 左方向にすでにクイーンがあるかチェック
	  // （右側には絶対存在しない。
	  for (int p = 0; p < x; p++){
	   if(board[p][y]){
	    return false;
	   }
	  }
	  
	  // 左上方向をチェック
	  int p = x;
	  int q = y;
	  while( p > 0 && q > 0){
	   if(board[--p][--q]) return false;
	  }
	  
	  // 左した方向をチェック
	  p = x;
	  q = y;
	  
	  while( p > 0 && q < 7){
	   if(board[--p][++q]) return false;
	  }
	  return true;
	 }
	 
	 public static void showBoard(){
	  for(int y = 0; y < 8; y++){
	   for(int x = 0; x < 8; x++){
	    System.out.print(board[x][y] ? "Q " : ". ");
	   }
	   System.out.println();
	  }
	 }
	 
	 public static boolean solve(int x){
	  if (x == 8){
	   // すべての列にクイーンを置けたら
	   return true;
	  }
	  
	  for(int i = 0; i < 8; i++){
	   if(check(x,i)){
	    // (x,1)にクイーンが置けたら
	    // 実際におく
	    board[x][i] = true;
	    if(solve(x + 1)) {
	     // 次の列移行が成功ならこの列も背う高
	     return true;
	    } else {
	     // 次の列以降が失敗ならクイーンを置きなおす
	     board[x][i] = false;
	    }
	   }
	  }
	  // 結局全部失敗した
	  return false;
	 }
	 
	 public static void main(String[] args) {
	  // 最初の列からスタート
	  if(solve(0)){
	   showBoard();
	  }
	 }

	}
