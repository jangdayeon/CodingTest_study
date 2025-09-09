import java.util.*;

class Solution {
    private List<Node> nodeInfoList;
    private List<Integer> preorderList = new ArrayList<>();
    private List<Integer> postorderList = new ArrayList<>();

    private class Node {
        int num, x, y;
        Node left, right;
        int min, max; // 허용 x 범위 (exclusive 비교 사용)
        public Node(int num, int x, int y) {
            this.num = num; this.x = x; this.y = y;
            left = right = null;
            // 기본값은 전체 범위
            this.min = Integer.MIN_VALUE;
            this.max = Integer.MAX_VALUE;
        }
        @Override
        public String toString() {
            return num + " x=" + x + " [" + min + "," + max + "] L:" + (left!=null?left.num:"-") + " R:" + (right!=null?right.num:"-");
        }
    }

    public int[][] solution(int[][] nodeinfo) {
        int n = nodeinfo.length;
        int[][] answer = new int[2][n];

        // 노드 생성
        nodeInfoList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            nodeInfoList.add(new Node(i + 1, nodeinfo[i][0], nodeinfo[i][1]));
        }

        // y 내림차순, x 오름차순 정렬 (루트부터, 같은 레벨은 좌->우)
        Collections.sort(nodeInfoList, (a, b) -> {
            if (a.y == b.y) return a.x - b.x;
            return b.y - a.y;
        });

        // 레벨 기반 연결: 첫 노드는 루트
        List<Node> parent = new ArrayList<>();
        Node root = nodeInfoList.get(0);
        root.min = Integer.MIN_VALUE;
        root.max = Integer.MAX_VALUE;
        parent.add(root);

        // i 를 수동으로 증가시키며 같은 y값(=같은 레벨)인 노드들 모으기
        for (int i = 1; i < nodeInfoList.size();) {
            List<Node> child = new ArrayList<>();
            int childY = nodeInfoList.get(i).y;
            while (i < nodeInfoList.size() && nodeInfoList.get(i).y == childY) {
                child.add(nodeInfoList.get(i));
                i++;
            }

            int cIdx = 0; // child 리스트에서 소비할 인덱스
            for (Node p : parent) {
                // 왼쪽 자식 후보
                if (cIdx < child.size()) {
                    Node c = child.get(cIdx);
                    if (p.min < c.x && c.x < p.x) {
                        p.left = c;
                        c.min = p.min;
                        c.max = p.x;
                        cIdx++;
                    }
                }
                // 오른쪽 자식 후보
                if (cIdx < child.size()) {
                    Node c = child.get(cIdx);
                    if (p.x < c.x && c.x < p.max) {
                        p.right = c;
                        c.min = p.x;
                        c.max = p.max;
                        cIdx++;
                    }
                }
            }

            // 다음 레벨의 부모는 지금의 child 들(좌->우 순서)
            parent = child;
        }

        // 순회 결과 채우기
        preorder(root);
        postorder(root);
        for (int i = 0; i < n; i++) {
            answer[0][i] = preorderList.get(i);
            answer[1][i] = postorderList.get(i);
        }
        return answer;
    }

    private void preorder(Node now) {
        if (now == null) return;
        preorderList.add(now.num);
        preorder(now.left);
        preorder(now.right);
    }

    private void postorder(Node now) {
        if (now == null) return;
        postorder(now.left);
        postorder(now.right);
        postorderList.add(now.num);
    }
}
