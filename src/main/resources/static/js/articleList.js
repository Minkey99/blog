const createButton = document.getElementById('create-btn');

if(createButton) {
    createButton.addEventListener('click', event => {
        let id = document.getElementById('article-id').value;
        // JSON 형식으로 데이터를 보내기 위한 설정
        fetch(`/new-article`, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify({ id: id }) // 서버가 요구하는 형식에 맞게 데이터 전송
        })
            .then(response => response.json()) // 응답을 JSON으로 변환
            .then(data => {
                console.log(data); // 응답 로그 출력
                alert('Post creation successful');
                location.replace('/articles');
            })
            .catch(error => console.error('Error:', error)); // 오류 처리
    });
}

document.addEventListener("DOMContentLoaded", function() {
    fetchArticles();
});

function fetchArticles() {
    fetch('/api/articles')
        .then(response => response.json())
        .then(articles => {
            const articlesRow = document.getElementById('articlesRow');
            articles.forEach((article, index) => {
                articlesRow.appendChild(createArticleCard(article, index));
            });
        })
        .catch(error => console.error('Error fetching articles:', error));
}

/* index+1 부분 article.id 로 수정해야함 */
function createArticleCard(article, index) {
    const card = document.createElement("div");
    card.className = 'card';
    card.innerHTML = `
    <div class="container">
      <div class="card-header">NO. ${article.id}</div> 
      <div class="card-body"> 
        <h5 class="title">${article.title}</h5>
        <p class="content">${article.content}</p>
        <a href="/articles/${article.id}" class="btn btn-primary">View</a>
      </div>
    </div>
  `;
    const br = document.createElement("br");
    card.appendChild(br);
    return card;
}