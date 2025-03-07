import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class BOJ_감시{
    static int[][] map;
    static int min = Integer.MAX_VALUE;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        map = new int[n][m];
        List<Integer> cctvList = new ArrayList<>();
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j< m; j++){
                map[i][j] = sc.nextInt();
                if(map[i][j] != 0 && map[i][j] != 6 ){
                    cctvList.add(map[i][j]);
                }
            }
        }

        int[] cctv = new int[cctvList.size()];
        for(int i = 0; i < cctv.length; i++){
            cctv[i] = cctvList.get(i);
        }

        comb(cctv, new int[cctv.length], 0, 0);

        System.out.println(min);
        
    }

    static void comb(int[] arr, int[] sel, int depth, int idx){
        if(sel.length == depth){
            int n = map.length;
            int m = map[0].length;
            // 맵 복사
            int[][] copyMap = new int[n][m];
            for(int i = 0; i < n; i++){
                for(int j = 0; j < m; j++){
                    copyMap[i][j] = map[i][j];
                }
            }
            
            int cctvIdx = 0;
            for(int i = 0; i < n; i++){
                for(int j = 0; j < m; j++){
                    if(copyMap[i][j] <=5 && copyMap[i][j]>=1){
                        int cctvInfo = copyMap[i][j];
                        if(cctvInfo == 1){
                            if(sel[cctvIdx] == 1){
                                for(int q = i; q >= 0; q--){// 위
                                    if(copyMap[q][j] == 6){
                                        break;
                                    }else if(copyMap[q][j] == 0){
                                        copyMap[q][j] = 9;
                                    }
                                }
                            }else if(sel[cctvIdx] == 2){
                                for(int q = j; q < m; q++){//오른쪽
                                    if(copyMap[i][q] == 6){
                                        break;
                                    }else if(copyMap[i][q] == 0){
                                        copyMap[i][q] = 9;
                                    }
                                }
                            }else if(sel[cctvIdx] == 3){
                                for(int q = i; q < n; q++){//아래
                                    if(copyMap[q][j] == 6){
                                        break;
                                    }else if(copyMap[q][j] == 0){
                                        copyMap[q][j] = 9;
                                    }
                                }
                            }else{
                                for(int q = j; q >= 0; q--){//왼쪽
                                    if(copyMap[i][q] == 6){
                                        break;
                                    }else if(copyMap[i][q] == 0){
                                        copyMap[i][q] = 9;
                                    }
                                }
                            }
                        }else if(cctvInfo == 2){
                            if(sel[cctvIdx] == 1){//위 아래
                                for(int q = i; q >= 0; q--){// 위
                                    if(copyMap[q][j] == 6){
                                        break;
                                    }else if(copyMap[q][j] == 0){
                                        copyMap[q][j] = 9;
                                    }
                                }
                                for(int q = i; q < n; q++){//아래
                                    if(copyMap[q][j] == 6){
                                        break;
                                    }else if(copyMap[q][j] == 0){
                                        copyMap[q][j] = 9;
                                    }
                                }
                            }else{// 왼쪽 오른쪽
                                for(int q = j; q < m; q++){//오른쪽
                                    if(copyMap[i][q] == 6){
                                        break;
                                    }else if(copyMap[i][q] == 0){
                                        copyMap[i][q] = 9;
                                    }
                                }
                                for(int q = j; q >= 0; q--){//왼쪽
                                    if(copyMap[i][q] == 6){
                                        break;
                                    }else if(copyMap[i][q] == 0){
                                        copyMap[i][q] = 9;
                                    }
                                }
                            }
                        }else if(cctvInfo == 3){
                            if(sel[cctvIdx] == 1){//위 오른쪽
                                for(int q = i; q >= 0; q--){// 위
                                    if(copyMap[q][j] == 6){
                                        break;
                                    }else if(copyMap[q][j] == 0){
                                        copyMap[q][j] = 9;
                                    }
                                }
                                for(int q = j; q < m; q++){//오른쪽
                                    if(copyMap[i][q] == 6){
                                        break;
                                    }else if(copyMap[i][q] == 0){
                                        copyMap[i][q] = 9;
                                    }
                                }
                            }else if(sel[cctvIdx] == 2){//오른쪽 아래
                                for(int q = j; q < m; q++){//오른쪽
                                    if(copyMap[i][q] == 6){
                                        break;
                                    }else if(copyMap[i][q] == 0){
                                        copyMap[i][q] = 9;
                                    }
                                }
                                for(int q = i; q < n; q++){//아래
                                    if(copyMap[q][j] == 6){
                                        break;
                                    }else if(copyMap[q][j] == 0){
                                        copyMap[q][j] = 9;
                                    }
                                }
                            }else if(sel[cctvIdx] == 3){//아래 왼쪽
                                for(int q = i; q < n; q++){//아래
                                    if(copyMap[q][j] == 6){
                                        break;
                                    }else if(copyMap[q][j] == 0){
                                        copyMap[q][j] = 9;
                                    }
                                }
                                for(int q = j; q >= 0; q--){//왼쪽
                                    if(copyMap[i][q] == 6){
                                        break;
                                    }else if(copyMap[i][q] == 0){
                                        copyMap[i][q] = 9;
                                    }
                                }
                            }else{//왼쪽 위
                                for(int q = j; q >= 0; q--){//왼쪽
                                    if(copyMap[i][q] == 6){
                                        break;
                                    }else if(copyMap[i][q] == 0){
                                        copyMap[i][q] = 9;
                                    }
                                }
                                for(int q = i; q >= 0; q--){
                                    if(copyMap[q][j] == 6){// 위
                                        break;
                                    }else if(copyMap[q][j] == 0){
                                        copyMap[q][j] = 9;
                                    }
                                }
                            }
                        }else if(cctvInfo == 4){
                            if(sel[cctvIdx] == 1){//위 오른쪽 왼쪽
                                for(int q = i; q >= 0; q--){// 위
                                    if(copyMap[q][j] == 6){
                                        break;
                                    }else if(copyMap[q][j] == 0){
                                        copyMap[q][j] = 9;
                                    }
                                }
                                for(int q = j; q < m; q++){//오른쪽
                                    if(copyMap[i][q] == 6){
                                        break;
                                    }else if(copyMap[i][q] == 0){
                                        copyMap[i][q] = 9;
                                    }
                                }
                                for(int q = j; q >= 0; q--){//왼쪽
                                    if(copyMap[i][q] == 6){
                                        break;
                                    }else if(copyMap[i][q] == 0){
                                        copyMap[i][q] = 9;
                                    }
                                }
                            }else if(sel[cctvIdx] == 2){//오른쪽 아래 위
                                for(int q = j; q < m; q++){//오른쪽
                                    if(copyMap[i][q] == 6){
                                        break;
                                    }else if(copyMap[i][q] == 0){
                                        copyMap[i][q] = 9;
                                    }
                                }
                                for(int q = i; q < n; q++){//아래
                                    if(copyMap[q][j] == 6){
                                        break;
                                    }else if(copyMap[q][j] == 0){
                                        copyMap[q][j] = 9;
                                    }
                                }
                                for(int q = i; q >= 0; q--){// 위
                                    if(copyMap[q][j] == 6){
                                        break;
                                    }else if(copyMap[q][j] == 0){
                                        copyMap[q][j] = 9;
                                    }
                                }
                            }else if(sel[cctvIdx] == 3){//아래 왼쪽 오른쪽
                                for(int q = i; q < n; q++){//아래
                                    if(copyMap[q][j] == 6){
                                        break;
                                    }else if(copyMap[q][j] == 0){
                                        copyMap[q][j] = 9;
                                    }
                                }
                                for(int q = j; q >= 0; q--){//왼쪽
                                    if(copyMap[i][q] == 6){
                                        break;
                                    }else if(copyMap[i][q] == 0){
                                        copyMap[i][q] = 9;
                                    }
                                }
                                for(int q = j; q < m; q++){//오른쪽
                                    if(copyMap[i][q] == 6){
                                        break;
                                    }else if(copyMap[i][q] == 0){
                                        copyMap[i][q] = 9;
                                    }
                                }
                            }else{//왼쪽 위 아래
                                for(int q = j; q >= 0; q--){//왼쪽
                                    if(copyMap[i][q] == 6){
                                        break;
                                    }else if(copyMap[i][q] == 0){
                                        copyMap[i][q] = 9;
                                    }
                                }
                                for(int q = i; q >= 0; q--){
                                    if(copyMap[q][j] == 6){// 위
                                        break;
                                    }else if(copyMap[q][j] == 0){
                                        copyMap[q][j] = 9;
                                    }
                                }
                                for(int q = i; q < n; q++){//아래
                                    if(copyMap[q][j] == 6){
                                        break;
                                    }else if(copyMap[q][j] == 0){
                                        copyMap[q][j] = 9;
                                    }
                                }
                            }
                        }else{
                            for(int q = j; q >= 0; q--){//왼쪽
                                if(copyMap[i][q] == 6){
                                    break;
                                }else if(copyMap[i][q] == 0){
                                    copyMap[i][q] = 9;
                                }
                            }
                            for(int q = i; q >= 0; q--){
                                if(copyMap[q][j] == 6){// 위
                                    break;
                                }else if(copyMap[q][j] == 0){
                                    copyMap[q][j] = 9;
                                }
                            }
                            for(int q = i; q < n; q++){//아래
                                if(copyMap[q][j] == 6){
                                    break;
                                }else if(copyMap[q][j] == 0){
                                    copyMap[q][j] = 9;
                                }
                            }
                            for(int q = j; q < m; q++){//오른쪽
                                if(copyMap[i][q] == 6){
                                    break;
                                }else if(copyMap[i][q] == 0){
                                    copyMap[i][q] = 9;
                                }
                            }
                        }
                    cctvIdx++;
                    }
                }
            }
            int count = 0;
            for(int i = 0; i < n; i++){
                for(int j = 0; j < m; j++){
                    if(copyMap[i][j] == 0){
                        count += 1;
                    }
                }
            }
            if(min > count){
                min = count;
            }
            return;
        }

        if(arr[idx] == 1 || arr[idx] == 3 || arr[idx] == 4){
            for(int i = 1; i <= 4; i++){
                sel[depth] = i;
                comb(arr, sel, depth+1, idx+1);
            }
        }else if(arr[idx] == 2){
            for(int i = 1; i<=2; i++){
                sel[depth] = i;
                comb(arr, sel, depth+1, idx+1);
            }
        }else{
            sel[depth] = 1;
            comb(arr, sel, depth+1, idx+1);
        }
    }
}