class Solution:
    def kidsWithCandies(self, candies: List[int], extraCandies: int) -> List[bool]:
        maxNumCandies = max(candies)
        for idx, candy in enumerate(candies):
            canHaveMaxCandies = (candy + extraCandies) >= maxNumCandies
            candies[idx] = canHaveMaxCandies
        return candies