class Solution:
    def equalPairs(self, grid: List[List[int]]) -> int:
        count = 0
        t_grid = list(map(list,zip(*grid))) # 전치행렬 t_grid 만들기
        for i in grid:
            for j in t_grid:
                if i == j:
                    count += 1
        return count
