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
      <div class="card-header">NO. ${index + 1}</div>
      <div class="card-body">
        <h5 class="card-title">${article.title}</h5>
        <p class="card-text">${article.content}</p>
        <a href="/articles/${index + 1}" class="btn btn-primary">View</a>
      </div>
    </div>
  `;
    const br = document.createElement("br");
    card.appendChild(br);
    return card;
}