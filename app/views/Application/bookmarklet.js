function iprl5(){
    var d=document,
    z=d.createElement('scr'+'ipt'),
    b=d.body,
    l=d.location;
    try{
        if(!b)
            throw(0);
        d.title='(Saving...) '+d.title;
        z.setAttribute('src','@@{Application.input}?u='+encodeURIComponent(l.href)+'&t='+(new Date().getTime()));
        b.appendChild(z);
    }catch(e){
        alert('Please wait until the page has loaded.');
    }
}
iprl5();
void(0)