from typing import Optional


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    def isValidBST(self, root: Optional[TreeNode]) -> bool:

        return self.isValidLeft(root.left, root.val) & self.isValidRight(root.right, root.val)

    def isValidLeft(self, root: Optional[TreeNode], parentData: int) -> bool:
        if root is None:
            return True

        if root.val < parentData:
            return self.isValidLeft(root.left, root.val) & self.isValidRight(root.right, root.val) & self.getMax(root) < parentData
        else:
            return False

    def isValidRight(self, root: Optional[TreeNode], parentData: int) -> bool:
        if root is None:
            return True

        if root.val > parentData:
            return self.isValidLeft(root.left, root.val) & self.isValidRight(root.right, root.val) & self.getMin(root) > parentData
        else:
            return False

    def getMax(self, root: Optional[TreeNode]) -> int:
        if root.right is None:
            return root.val
        else:
            return self.getMax(root.right)

    def getMin(self, root: Optional[TreeNode]) -> int:
        if root.left is None:
            return root.val
        else:
            return self.getMin(root.left)
