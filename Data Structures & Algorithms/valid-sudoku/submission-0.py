class Solution:
    def isValidSudoku(self, board: List[List[str]]) -> bool:
        rows = [0] * 9
        cols =[0] * 9
        box = [0] *9

        for r in range(9):
            for c in range(9):
                if board[r][c] =='.':
                    continue
                
                val = int(board[r][c])
                mask = 1<<val

                boxIdx = (r//3) * 3 + (c//3)

                if (mask&rows[r]):
                    return False
                if (mask & cols[c]):
                    return False
                if (mask & box[boxIdx]):
                    return False

                rows[r] |=mask
                cols[c] |=mask
                box[boxIdx] |=mask

            
        return True
