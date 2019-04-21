var twoSum = function(nums, target) {
  const complements = {};

  for (let i = 0; i < nums.length; i++) {
    const num = nums[i];

    if (num in complements) {
      return [complements[num], i];
    }

    complements[target - num] = i;
  }

  return [];
};

// var twoSum = function(nums, target) {
//   const map = {};
//   for (let i = 0; i < nums.length - 1; i++) {
//     map[target - nums[i]] = i;
//     if (nums[i + 1] in map) return [map[nums[i + 1]], i + 1];
//   }
// };

const start = Date.now();
console.log(twoSum([2, 7, 11, 15], 9)); // [0, 1]
console.log(twoSum([0, 4, 3, 0], 0)); // [0, 3]
const end = Date.now();
console.log({
  start,
  end,
  difference: end - start
});
