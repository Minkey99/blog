document.addEventListener("DOMContentLoaded", function() {
    // 예시 데이터, 실제로는 서버로부터 받아오거나 다른 방식으로 구현해야 합니다.
    const article = {
        title: "새로운 제목",
        content: "새로운 내용입니다...."
    };

    // title과 content 요소를 찾아서 내용을 업데이트합니다.
    const titleElement = document.getElementById("title");
    const contentElement = document.getElementById("content");

    if (titleElement && contentElement) {
        titleElement.textContent = article.title; // .innerHTML을 사용할 수도 있지만, XSS 공격에 더 취약할 수 있습니다.
        contentElement.textContent = article.content;
    }
});

const deleteButton = document.getElementById('delete-btn');

if(deleteButton) {
    deleteButton.addEventListener('click', event => {
        let id = document.getElementById('article-id').value;
        fetch(`/api/articles/${id}`, {
            method: 'DELETE'
        })
            .then(() => {
                alert('삭제가 완료되었습니다.');
                location.replace('/articles');
            });
    });
}

document.addEventListener("DOMContentLoaded", function() {
    const modifyButton = document.getElementById("modify-btn");

    if (modifyButton) {
        modifyButton.addEventListener('click',event => {
            let params = new URLSearchParams(location.search);
            let id = parseInt(params.get("id"));

            fetch(`/api/articles/${id}`, {
                method: "PUT",
                headers: {
                    "Content-Type": "application/json",
                },
                body: JSON.stringify({
                    title: document.getElementById("title").value,
                    content: document.getElementById("content").value
                })
            })
                .then(() => {
                    alert('수정이 완료되었습니다.');
                    location.replace(`/articles/${id}`);
                });
        });
    }
    else {
        /*modifyButton.addEventListener('click',event => {
            let params = new URLSearchParams(location.search);
            let id = parseInt(params.get("id"));

            fetch(`/api/articles/${id}`, {
                method: "PUT",
                headers: {
                    "Content-Type": "application/json",
                },
                body: JSON.stringify({
                    title: document.getElementById("title").value,
                    content: document.getElementById("content").value
                })
            })
                .then(() => {
                    alert('수정이 완료되었습니다.');
                    location.replace(`/articles/${id}`);
                });
        });*/
    }
});