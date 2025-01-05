import requests
import json
from datetime import datetime

# 基础配置
BASE_URL = "http://localhost:8081/api"
headers = {
    'Content-Type': 'application/json'
}

# 测试结果统计
test_results = {
    'total': 0,
    'passed': 0,
    'failed': 0
}

def print_response(response):
    """打印响应结果"""
    print(f"Status Code: {response.status_code}")
    print(f"Response: {response.text}\n")

def test_endpoint(method, endpoint, data=None, params=None, expected_status=200):
    """测试单个接口"""
    test_results['total'] += 1
    url = f"{BASE_URL}{endpoint}"

    try:
        if method.upper() == 'GET':
            response = requests.get(url, params=params, headers=headers)
        elif method.upper() == 'POST':
            response = requests.post(url, json=data, headers=headers)
        elif method.upper() == 'PUT':
            response = requests.put(url, json=data, headers=headers)
        elif method.upper() == 'DELETE':
            response = requests.delete(url, headers=headers)

        print(f"\nTesting {method} {endpoint}")
        print(f"Request Data: {data if data else params}")
        print_response(response)

        if response.status_code == expected_status:
            test_results['passed'] += 1
            print("✅ Test passed")
        else:
            test_results['failed'] += 1
            print("❌ Test failed")

        return response.json() if response.text else None

    except Exception as e:
        test_results['failed'] += 1
        print(f"❌ Test failed with error: {str(e)}")
        return None

def test_user_endpoints():
    """测试用户相关接口"""
    print("\n=== Testing User Endpoints ===")

    # 测试用户登录
    login_data = {
        "username": "admin",
        "password": "123456"
    }
    user_data = test_endpoint('POST', '/user/login', login_data)

    # 测试用户分页查询
    test_endpoint('GET', '/user/page', params={'current': 1, 'size': 10})

    # 测试创建用户
    new_user = {
        "username": f"test_user_{datetime.now().timestamp()}",
        "password": "123456",
        "email": "test@example.com"
    }
    created_user = test_endpoint('POST', '/user', new_user)

    if created_user:
        # 测试获取用户详情
        test_endpoint('GET', f'/user/{created_user["data"]}')

        # 测试更新用户
        update_data = {
            "id": created_user["data"],
            "email": "updated@example.com"
        }
        test_endpoint('PUT', '/user', update_data)

        # 测试删除用户
        test_endpoint('DELETE', f'/user/{created_user["data"]}')

def test_article_endpoints():
    """测试文章相关接口"""
    print("\n=== Testing Article Endpoints ===")

    # 测试文章分页查询
    test_endpoint('GET', '/article/page', params={'current': 1, 'size': 10})

    # 测试创建文章
    new_article = {
        "title": f"Test Article {datetime.now()}",
        "content": "This is a test article content",
        "submitterId": 1
    }
    created_article = test_endpoint('POST', '/article/submit', new_article)

    if created_article:
        article_id = created_article["data"]

        # 测试获取文章详情
        test_endpoint('GET', f'/article/{article_id}')

        # 测试审核文章
        test_endpoint('PUT', f'/article/review/{article_id}',
                     params={'status': 'APPROVED', 'comments': 'Approved by test'})

        # 测试获取用户文章
        test_endpoint('GET', '/article/user/1', params={'current': 1, 'size': 10})

        # 测试获取待审核文章
        test_endpoint('GET', '/article/pending', params={'current': 1, 'size': 10})

def test_department_endpoints():
    """测试部门相关接口"""
    print("\n=== Testing Department Endpoints ===")

    # 测试获取部门列表
    test_endpoint('GET', '/department/list')

    # 测试创建部门
    new_dept = {
        "deptName": f"Test Department {datetime.now()}",
        "parentId": 0
    }
    created_dept = test_endpoint('POST', '/department', new_dept)

    if created_dept:
        dept_id = created_dept["data"]

        # 测试获取部门详情
        test_endpoint('GET', f'/department/{dept_id}')

        # 测试更新部门
        update_data = {
            "id": dept_id,
            "deptName": "Updated Department"
        }
        test_endpoint('PUT', '/department', update_data)

        # 测试删除部门
        test_endpoint('DELETE', f'/department/{dept_id}')

def test_review_comment_endpoints():
    """测试评论相关接口"""
    print("\n=== Testing Review Comment Endpoints ===")

    # 测试获取文章评论
    test_endpoint('GET', '/review-comment/article/1', params={'current': 1, 'size': 10})

    # 测试创建评论
    new_comment = {
        "articleId": 1,
        "reviewerId": 1,
        "content": "This is a test comment"
    }
    created_comment = test_endpoint('POST', '/review-comment', new_comment)

    if created_comment:
        # 测试删除评论
        test_endpoint('DELETE', f'/review-comment/{created_comment["data"]}')

def main():
    """主测试函数"""
    print("Starting API Tests...\n")

    # 运行所有测试
    test_user_endpoints()
    test_article_endpoints()
    test_department_endpoints()
    test_review_comment_endpoints()

    # 打印测试结果统计
    print("\n=== Test Results ===")
    print(f"Total Tests: {test_results['total']}")
    print(f"Passed: {test_results['passed']}")
    print(f"Failed: {test_results['failed']}")
    print(f"Success Rate: {(test_results['passed'] / test_results['total'] * 100):.2f}%")

if __name__ == "__main__":
    main()