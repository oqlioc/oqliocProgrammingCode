
#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <stdlib.h>
 
typedef struct Node {
    int            key;
    int            data;
    struct Node *left;
    struct Node *right;
} Node;
 
int GetData(Node *head, int key, int *data);
int Insert(Node *head, int key, int data);
int Delete(Node *head, int key);
int Display(Node *head);
void PreorderTraversal(Node *root);
void InorderTraversal(Node *root);
void PostorderTraversal(Node *root);
 
void main()
{
    Node *head;
    int data = 2018;
    int key;
 
    int button;
    char sayYesOrNo;
    
    head = (Node *)malloc(sizeof(Node));
    head->left = NULL;
    head->right = NULL;
 
    do {
        puts("========== MENU ==========");
        puts("1. Get data");
        puts("2. Insert node");
        puts("3. Delete node");
        puts("4. Show all nodes");
        puts("5. Exit");
        puts("==========================");
        printf("Select what you want to do : ");
        scanf("%d", &button);
 
        switch (button)
        {
        case 1:    // Get data
            GetData(head, key, &data);
            break;
        case 2:    // Insert node
            printf("Input key : ");
            scanf("%d", &key);
            Insert(head, key, data);
            break;
        case 3:    // Delete node
            printf("Input key : ");
            scanf("%d", &key);
            Delete(head, key);
            break;
        case 4:    // Show all nodes
            Display(head);
            break;
        }
 
        printf("계속하시겠습니까?(Y/N) : ");
        rewind(stdin);
        scanf("%c", &sayYesOrNo);
    } while (sayYesOrNo == 'Y' || sayYesOrNo == 'y');
}
 
int GetData(Node *head, int key, int data)
{
    Node *root;
    Node *cur;
 
    root = head->left;
 
    // 더미 노드에 연결된 루트 노드 설정
    if (head->left == NULL) {
        puts("노드가 1도 없습니다.");
        return 0;
    } else {
        cur = root;
        while (1) {
            if (data == cur->data) {
                puts("중복된 데이터가 존재합니다!");
                return 0;
            } else if (data < cur->data) {
                if (cur->left == NULL) {
                    break;
                }
                cur = cur->left;
            } else {
                if (cur->right == NULL) {
                    break;
                }
                cur = cur->right;
            }
        }
        
        // 왼쪽에 붙일 지 오른쪽에 붙일 지 결정
        if (data < cur->data) {
            cur->left->data = data;
        }
        else {
            cur->right->data = data;
        }
 
        puts("입력 완료!");
        return 1;
    }
}
 
int Insert(Node *head, int key, int data)
{
    Node *root;
    Node *cur;
    Node *new1;
    
    // 새로운 노드 생성
    if ((new1 = cur = (Node *)calloc(1, sizeof(Node))) == NULL) {
        puts("failed to memory allocation!");
        exit(-1);
    }
    new1->key = key;
    new1->data = data;
    new1->left = NULL;
    new1->right = NULL;
        
    // 첫 노드는 탐색할 필요가 없으므로 바로 루트 노드로 선정
    if (head->left == NULL) {
        puts("첫 노드를 생성했습니다.");
        head->left = new1;
        return 1;
    } else {
        // 이미 노드가 있는 경우 탐색 진행            
        root = head->left;
        cur = root;
        while (1) {
            if (new1->key == cur->key) {
                puts("중복된 데이터가 존재합니다!");
                return 0;
            } else if (new1->key < cur->key) {
                if (cur->left == NULL) {
                    break;
                }
                cur = cur->left;
            } else {
                if (cur->right == NULL) {
                    break;
                }
                cur = cur->right;
            }
        }
    }
 
    // 왼쪽에 붙일 지 오른쪽에 붙일 지 결정
    if (new1->key < cur->key) {
        cur->left = new1;
    } else {
        cur->right = new1;
    }
 
    puts("노드 추가 완료!");
    return 1;
}
 
int Delete(Node *head, int delkey)
{
    Node *root = head->left;
    Node *cur, *del = NULL;
 
    cur = root;
 
    while (1) {
        if (delkey == cur->left->key || delkey == cur->right->key) {
            puts("유레카");
            break;
        } else if (delkey < cur->key) {
            if (cur->left == NULL) {
                puts("찾는 키 값 없음");
                return 0;
            }
            cur = cur->left;
        } else {
            if (cur->right == NULL) {
                puts("찾는 키 값 없음");
                return 0;
            }
            cur = cur->right;
        }
    }
 
    if (delkey < cur->key) {
        cur->left = del;
    }
    else {
        cur->right = del;
    }
 
    // 자식 노드가 0개인 경우
    if (del->left == NULL && del->right == NULL) {
        if (delkey < cur->key) {
            cur->right = NULL;
        }
        else {
            cur->left = NULL;
        }
 
        free(del);
        puts("삭제 완료");
        return 1;
    }
 
    // 자식 노드가 1개인 경우
 
    // 자식 노드가 2개인 경우
}
 
int Display(Node *head)
{
    Node *root;
 
    if (head->left == NULL) {
        puts("노드가 1도 없습니다.");
        return 0;
    }
 
    root = head->left;
 
    // preorder traversal
    puts("preorder traversal :");
    PreorderTraversal(root);
    puts("");
 
    // inorder traversal
    puts("inorder traversal :");
    InorderTraversal(root);
    puts("");
 
    // postorder traversal
    puts("postorder traversal :");
    PostorderTraversal(root);
    puts("");
 
    return 1;
}
 
void PreorderTraversal(Node *root)
{
    if (root == NULL) return;
    printf("%d ", root->key);
    PreorderTraversal(root->left);
    PreorderTraversal(root->right);
}
 
void InorderTraversal(Node *root)
{
    if (root == NULL) return;
    InorderTraversal(root->left);
    printf("%d ", root->key);
    InorderTraversal(root->right);
}
 
void PostorderTraversal(Node *root)
{
    if (root == NULL) return;
    PostorderTraversal(root->left);
    PostorderTraversal(root->right);
    printf("%d ", root->key);
}
