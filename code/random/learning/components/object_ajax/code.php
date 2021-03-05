		
				<?php while($row = mysqli_fetch_array($result)) {
						$post_id = ($row['post_id']);
						$individual_post = "post_" . ($row['post_id']);
						$individual_post_id = ($row['post_id']);
						$individual_text_id = "text_" . ($row['post_id']);
						$editable_text_id = "edit_text_" . ($row['post_id']);
						$save_button_id = "save_" . ($row['post_id']);
						$cancel_button_id = "cancel_" . ($row['post_id']);	
						$individual_like_id = "like_" . ($row['post_id']);	
						$individual_post = new Posts($post_id, $logged_in_user);
						$individual_post->getUserPost($post_id);			
				?>  
					<!-- Individual Posts--> 
					<div class = "individual-post">
						<div class = "display-inline">	
							<p class = "display-inline"><b>Post ID: 		</b><?php echo ($individual_post->post_id);			?></p>	
							<p class = "display-inline"><b>Post From: 	</b><?php echo ($individual_post->post_from);		?></p>	
							<p class = "display-inline"><b>Post To: 		</b><?php echo ($individual_post->post_to);			?></p>	
						</div>	
						<p id = "<?php echo ($individual_text_id) ?>" class = "post-text"><b></b><?php echo ($individual_post->post_text);?></p>
						<textarea rows="4" cols="50" id = "<?php echo $editable_text_id ?>" class = "post-text" style="display:none"><?php echo ($individual_post->post_text);?></textarea>
						<p><b>Created	 	</b><?php echo ($individual_post->created);			?></p>		
						
						<!-- All editing buttons -->
						<div class = "editing-buttons">
							<?php if (strcasecmp($individual_post->post_from,$logged_in_user)==0) { ?>
								<button type="button" id="<?php echo $individual_post_id; ?>" class="edit-button">Edit</button>	
								<button type="button" id="<?php echo $save_button_id; ?>" class="save-button" style="display:none" >Save</button>	
								<button type="button" id="<?php echo $cancel_button_id; ?>" class="cancel-button" style="display:none" >Cancel</button>	
							<?php	} else { ?>
								<button type="button" id="" class="">Report</button>	
							<?php	} ?>
						</div>
						
						<!-- Likes -->
						<div class = "likes">
							<?php echo "<br />" . "Total Likes: " . ($individual_post->total_likes) . "<br />"; 		
								if (in_array($logged_in_user_id, ($individual_post->like_id))) {
									echo "<p id =  " .  $individual_like_id . " class = \"like\"><strong>Unlike</strong></p>";
								} else {
									echo "<p id = " .  $individual_like_id . " class = \"like\"><strong>Like</strong></p>";
								 } 
							?>
						</div>	
						
						<!-- Comments -->
						<div class = "comments">
							<textarea rows="2" cols="50" id = "" class = "" ></textarea>

						<?php
							echo "<br />";
							$result_comments = mysqli_query($conn,"SELECT * FROM comments WHERE comment_post_id = '$post_id'");
							
							while($row_comments  = mysqli_fetch_array($result_comments )) {
								$individual_comment 	= "comment_" . $post_id ;
								$individual_comment 	= new Comments($post_id, $logged_in_user);
								$individual_comment->getPostComments($post_id);	
							
								echo ($individual_comment->comment_from);	
								echo ($individual_comment->comment_to);	
								echo ($individual_comment->comment);	
								echo ($individual_comment->created);	
								echo ($individual_comment->updated);	
								echo "<br />";
							}
			
						?>				
						
						</div>

					</div>				
				<?php } ?>	
	