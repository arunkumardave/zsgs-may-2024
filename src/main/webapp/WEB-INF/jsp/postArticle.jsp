<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<form action="postArticle" method="post">
    <input type="text" name="title" placeholder="Title" required /><br>
    <textarea name="content" placeholder="Content" required></textarea><br>
    <input type="text" name="author" placeholder="Author" required /><br>
    <select name="category">
        <option value="Tech">Tech</option>
        <option value="Lifestyle">Lifestyle</option>
        <option value="Education">Education</option>
        <option value="Entertainment">Entertainment</option>
        <option value="Engineering">Engineering</option>
        <option value="Life Style">Life Style</option>
        <option value="Marketing">Marketing</option>
    </select><br>
    <button class="action-button" type="submit">Post</button>
</form>
