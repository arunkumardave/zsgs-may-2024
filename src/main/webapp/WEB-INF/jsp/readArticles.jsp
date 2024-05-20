<div id="articles-list">
    <!-- Articles will be populated here via JavaScript -->
</div>
<script>
    document.addEventListener("DOMContentLoaded", function() {
        fetchArticles();
        function fetchArticles() {
            fetch('readArticles')
                .then(response => response.json())
                .then(data => {
                    const articlesList = document.getElementById('articles-list');
                    articlesList.innerHTML = '';
                    data.forEach(article => {
                        const articleElement = document.createElement('div');
                        articleElement.innerHTML = `
                            <h4>${article.title}</h4>
                            <p>${article.content}</p>
                            <p>Author: ${article.author}</p>
                            <p>Category: ${article.category}</p>
                            <button class="action-button" onclick="updateArticle(${article.id})">Update</button>
                            <button class="action-button" onclick="removeArticle(${article.id})">Remove</button>
                        `;
                        articlesList.appendChild(articleElement);
                    });
                });
        }

        window.updateArticle = function(id) {
            // Implement update functionality
        }

        window.removeArticle = function(id) {
            fetch(`removeArticle?id=${id}`, { method: 'POST' })
                .then(() => fetchArticles());
        }
    });
</script>
