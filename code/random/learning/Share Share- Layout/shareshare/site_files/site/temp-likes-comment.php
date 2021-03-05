<!-- Cut 1 -->



					
	<!-- END CUT 1 -->
			
					


					<!--Comments-->				
						<?php 
							$post_id = $row_post['post_id'];		
							$sql = "SELECT * FROM comments WHERE post_id = 'post_id' ORDER BY created DESC";
							$result_comment = $conn->query($sql) or die(mysqli_error());
						?>	  
						<?php while($row = $result_comment->fetch_assoc()) { ?>
							<div class = "comments">
								<p>The comment is: <?php echo $row['comment']; ?></p>
								<p>The comment is from: <?php echo $row['comment_from']; ?></p>
								<p>And the Post ID is: <?php echo ($post_id); ?></p>
								
							</div>
						<?php } ?>	
			
			
		
		