public class Knight {
    int x, y;

    public Knight() {
        this.x = 0;
        this.y = 0;
    }

    public void move(int option, int[][] map, int level) {
        switch (option) {
            case 1:
                map[y - 1][x - 2] = -10;
                y = y - 1; 
                x = x - 2;
                break;
            case 2:
                map[y - 2][x - 1] = -10;
                y = y - 2;
                x = x - 1;
                break;
            case 3:
                map[y - 1][x + 2] = -10;
                y = y - 1;
                x = x + 2;
                break;
            case 4:
                map[y - 2][x + 1] = -10;
                y = y - 2;
                x = x + 1;
                break;
            case 5:
                map[y + 1][x - 2] = -10; 
                y = y + 1;
                x = x - 2;
                break;
            case 6:
                map[y + 2][x - 1] = -10;
                y = y + 2;
                x = x - 1;
                break;
            case 7:
                map[y + 2][ x + 1] = -10;
                y = y + 2;
                x = x + 1;
                break;
            case 8: 
                map[y + 1][x + 2] = -10;
                y = y + 1;
                x = x + 2;
                break;
        }
    }

    public boolean canMove(int option, int[][] map) {
        boolean flag = false;
        switch (option) {
            case 1:
                if (x - 2 >= 0 & y - 1 >= 0) {
                    if (map[y - 1][x - 2] == 0) {
                        flag = true;
                    }
                } 
                break;
            case 2:
                if (x - 1 >= 0 & y - 2 >= 0) {
                    if (map[y - 2][x - 1] == 0) {
                        flag = true;
                    } 
                }
                break;
            case 3:
                if (x + 2 < map.length && y - 1 >= 0) {
                    if (map[y - 1][x + 2] == 0) {
                        flag = true;
                    }
                }
                break;
            case 4:
                if (x + 1 < map.length && y - 2 >= 0) {
                    if (map[y - 2][x + 1] == 0) {
                        flag = true;
                    }
                }
                break;
            case 5:
                if (x - 2 >= 0 && y + 1 < map.length) {
                    if (map[y + 1][x - 2] == 0) {
                        flag = true;
                    } 
                } 
                break;
            case 6:
                if (x - 1 >= 0 && y + 2 < map.length) {
                    if (map[y + 2][x - 1] == 0) {
                        flag = true;
                    } 
                }
                break;
            case 7:
                if (x + 1 < map.length && y + 2 < map.length) {
                    if (map[y + 2][ x + 1] == 0) {
                        flag = true;
                    }
                }
                break;
            case 8: 
                if (x + 2 < map.length && y + 1 < map.length) {
                    if (map[y + 1][x + 2] == 0) {
                        flag = true;
                    } 
                }
                break;
        }
        return flag;
    }
}
