import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main
{
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t < T + 1; t++) {

            StringTokenizer st = new StringTokenizer(br.readLine());
            int H = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());
            char[][] map = new char[H][W];

            // 처음 위치 좌표 x y
            int x = 0;
            int y = 0;

            for(int i = 0; i < H; i++){
                String temp = br.readLine();
                for(int j = 0; j < W; j++){
                    map[i][j] = temp.charAt(j);
                    if (map[i][j] == '>' || map[i][j] == 'v' || map[i][j] == '<' || map[i][j] == '^'){
                        x = i;
                        y = j;
                    }
                }
            }

            int N = Integer.parseInt(br.readLine());
            String ord = br.readLine();
            
            for(int i = 0; i < N; i++) {
            	switch(ord.charAt(i)) {
            	case 'U':
            	case 'D':
            	case 'R':
            	case 'L':
            		if (go_check(map, x, y, H, W, ord.charAt(i)) == true) {
            			map = turn_go(map, x, y, H, W, ord.charAt(i));
            			if (ord.charAt(i) == 'U') {
            				x -= 1;
            			}
            			else if (ord.charAt(i) == 'D') {
            				x += 1;
            			}
            			else if (ord.charAt(i) == 'R') {
            				y += 1;
            			}
						else if (ord.charAt(i) == 'L') {
							y -= 1;
						}
            		}
            		else {
            			map[x][y] = turn(x, y, ord.charAt(i));
            		}
            		break;
            	case 'S':
            		map = shoot(map, x, y, H, W, map[x][y]);
            		break;
            	}
            }
            System.out.printf("#%d ", t);
            for(int i = 0; i < H; i++) {
            	for(int j = 0; j < W; j++) {
            		System.out.print(map[i][j]);
            	}
            	System.out.println();
            }


        }
    }
    static boolean go_check(char[][] board, int x, int y, int h, int w, char dire) {
    	if (dire == 'L') {
    		if(0 <= y - 1 && board[x][y-1] == '.') {
    			return true;
    		}
    	}
    	else if (dire == 'U') {
    		if(0 <= x - 1 && board[x-1][y] == '.') {
    			return true;
    		}
    	}
    	else if (dire == 'R') {
    		if(y+1 < w && board[x][y+1] == '.') {
    			return true;
    		}
    	}
		else if (dire == 'D'){
			if(x+1 < h && board[x+1][y] == '.') {
				return true;
    		}
		}
    	return false;
    }
    
    static char[][] turn_go(char[][] board, int x, int y, int h, int w, char dire) {
    	board[x][y] = dire;
    	if (dire == 'L') {
    		if(0 <= y - 1 && board[x][y-1] == '.') {
    			board[x][y] = '.';
    			board[x][y-1] = '<';
    		}
    	}
    	else if (dire == 'U') {
    		if(0 <= x - 1 && board[x-1][y] == '.') {
    			board[x][y] = '.';
    			board[x-1][y] = '^';
    		}
    	}
    	else if (dire == 'R') {
    		if(y+1 < w && board[x][y+1] == '.') {
    			board[x][y] = '.';
    			board[x][y+1] = '>';
    		}
    	}
		else if (dire == 'D') {
			if(x+1 < h && board[x+1][y] == '.') {
    			board[x][y] = '.';
    			board[x+1][y] = 'v';
    		}
		}
    	return board;
    }
    
    static char turn(int x, int y, char dire) {
    	if (dire == 'L') {
    		return '<';
    	}
    	else if (dire == 'U') {
    		return '^';
    	}
    	else if (dire == 'R') {
    		return '>';
    	}
		else {
			return 'v';
		}
    }
    
    static char[][] shoot(char[][] board, int x, int y, int h, int w, char dire){
    	if (dire == '<') {
    		for (int i = y - 1; i >= 0; i--) {
    			if(board[x][i] == '#') {
    				break;
    			}
    			else if(board[x][i] == '*') {
    				board[x][i] = '.';
    				break;
    			}
    		}
    	}
    	else if (dire == '^') {
    		for (int i = x - 1; i >= 0; i--) {
    			if(board[i][y] == '#') {
    				break;
    			}
    			else if(board[i][y] == '*') {
    				board[i][y] = '.';
    				break;
    			}
    		}
    	}
    	else if (dire == '>') {
    		for (int i = y + 1; i < w; i++) {
    			if(board[x][i] == '#') {
    				break;
    			}
    			else if(board[x][i] == '*') {
    				board[x][i] = '.';
    				break;
    			}
    		}
    	}
    	// v 방향일때
		else {
			for (int i = x + 1; i < h; i++) {
    			if(board[i][y] == '#') {
    				break;
    			}
    			else if(board[i][y] == '*') {
    				board[i][y] = '.';
    				break;
    			}
    		}
		}
    	return board;
    }

}
