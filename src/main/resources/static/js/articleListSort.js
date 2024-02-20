document.addEventListener("DOMContentLoaded", function() {
    // Example posts data
    const posts = [
        { title: "Post 1", content: "Content of post 1. This post has more content and is larger." },
        { title: "Post 2", content: "Content of post 2." },
        { title: "Post 3", content: "Content of post 3. This has even more content than post 1. It's the largest of them all and should also be on its own line." },
    ];

    const postsContainer = document.getElementById('articlesRow');
    posts.forEach(post => {
        const postElement = createPostElement(post);
        postsContainer.appendChild(postElement);
    });
});

function createPostElement(post) {
    const containerDiv = document.createElement('div');
    containerDiv.className = 'post-container col-12'; // Ensures full width and block display

    const cardDiv = document.createElement('div');
    cardDiv.className = 'card';

    const cardBodyDiv = document.createElement('div');
    cardBodyDiv.className = 'card-body';

    const titleH5 = document.createElement('h5');
    titleH5.className = 'card-title';
    titleH5.textContent = post.title;

    const contentP = document.createElement('p');
    contentP.className = 'card-text';
    contentP.textContent = post.content;

    cardBodyDiv.appendChild(titleH5);
    cardBodyDiv.appendChild(contentP);

    cardDiv.appendChild(cardBodyDiv);
    containerDiv.appendChild(cardDiv);

    return containerDiv;
}