<div class="recent-changes">
    <h4>Recent Changes</h4>
    <ul id="recent-changes-list">
        <!-- Recent changes from the database will be populated here -->
    </ul>
</div>
<div class="redis-notifications">
    <h4>Redis Notifications</h4>
    <ul id="redis-notifications-list">
        <!-- Recent changes from Redis will be populated here -->
    </ul>
</div>
<script>
    document.addEventListener("DOMContentLoaded", function() {
        fetchRecentChanges();
        fetchRedisNotifications();

</script>