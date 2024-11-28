func maxProduct(nums []int) int {
    maxi := math.MinInt
    pref, suff := 1,1
    n := len(nums)
    for i:=0; i<n;i++{
        if(pref == 0) {
            pref = 1
        }
        if(suff == 0) {
            suff = 1
        }
        pref = pref*nums[i]
        suff = suff*nums[n-1-i]
        maxi = max(maxi,max(pref,suff))
    }
    return maxi
}