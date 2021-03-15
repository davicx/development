if($result > 0){
  echo 'SUCCESS';
}else{
  echo 'FAILURE';
}
 
/*
if(2>$result):
  echo 'FAILURE';
elseif(1==$result):
  echo 'SUCCESS';
endif;
 
echo ($result < 1)?'SUCCESS':'FAILURE';
for($ii=0; $ii<1; ++$ii) {
  if($ii==$result) {
    echo 'SUCCESS';
  }
}
 
switch($result){
case 0:
  echo 'FAILURE';
  break;
case 2:
  echo 'SUCCESS';
  break;
default:
  echo 'SUCCESS';
} 
