event.preventDefault();
try{
jQuery('html,body').animate({scrollTop:jQuery(this.hash).offset().top}, 500);
}catch(e){
jQuery('html,body').animate({scrollTop:0}, 500);
}
});
