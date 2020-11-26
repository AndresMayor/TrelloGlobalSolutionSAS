class ToDoView{

     etapa2Container = document.getElementById('Etapa2');

    constructor(todo){
        this.todo=todo;
        this.onDeleteFinish= null;
    }



    deleteTarea =()=>{
        let xhr = new XMLHttpRequest();
        xhr.addEventListener('readystatechange',()=>{

            if (xhr.readyState===4){
                    if(this.onDeleteFinish!=null){

                        var response = JSON.parse(xhr.responseText);
                        if(response.message==='operacion Exitosa'){
                            this.onDeleteFinish();
                        }else{
                            alert('no se pudo eliminar');
                        }

                        console.log(xhr.responseText);
                        
                    }
            }
        });
        xhr.open('DELETE','http://localhost:8080/Practico2/api/toDo/delete/'+this.todo.id);
        xhr.send();

    }


    agregarDoing =()=> {

        let obj = {

            id:0,
            descripccion:this.todo.descripccion,
            fecha:this.todo.fecha
        };
        console.log(JSON.stringify(obj));
    
        //[ara hacer el post]
        let xhr = new XMLHttpRequest();
        //response
        xhr.addEventListener('readystatechange',()=>{
            //readyStatae tiene varios estados el 5 estado es el complete 
            if(xhr.readyState===4){
                console.log(xhr.responseText);
                this.getAllTareasDoing();
                
            }
            
        });
        //request
        xhr.open('POST','http://localhost:8080/Practico2/api/Doing/create');
        xhr.setRequestHeader('Content-Type','application/json');
        //enciamos el objeto en string pero para mandaelo utlizamos JSON.stringfy();
        xhr.send( JSON.stringify(obj) );



    }




 getAllTareasDoing =()=> {
        
    let xhr = new XMLHttpRequest();
     
    xhr.addEventListener('readystatechange', ()=>{

        if(xhr.readyState === 4){
            let json = xhr.responseText;
            //de json a objeto con el parse!!
            let response = JSON.parse(json);

            console.log(response);
            this.etapa2Container.innerHTML='';

            let title  =document.createElement('h1');
            title.innerHTML='Doing';
            this.etapa2Container.appendChild(title);
            
            for(let i = 0; i<response.length ; i++){
            
                let DoingDTO = response[i];
                let view = new DoingView(DoingDTO);
                view .onDeleteFinish =()=>{
                    this.etapa2Container.removeChild(document.getElementById('doing'+DoingDTO.id));
                };
                this.etapa2Container.appendChild(view.render());

            }          
                

        }

    })

    xhr.open('GET','http://localhost:8080/Practico2/api/Doing/allDoing');
    xhr.send();

    

};





    render =()=>{

        let componet = document.createElement('div');
        componet.id='todo'+this.todo.id;
        componet.className='todoComponent';

        let descripccion = document.createElement('p');
        descripccion.className='descripccionToDo';

        let fecha = document.createElement('small');
        let delBtn = document.createElement('button');
        let avanzarBtn = document.createElement('button');
        
        delBtn.innerHTML='X';
        delBtn.className='delBtn';

        avanzarBtn.innerHTML='>';
        avanzarBtn.className='avanzarBtn';

        descripccion.innerHTML=this.todo.descripccion;
        fecha.innerHTML=this.todo.fecha;

        componet.appendChild(descripccion);
        componet.appendChild(fecha);
        componet.appendChild(delBtn);
        componet.appendChild(avanzarBtn);

        //comportamientos

        delBtn.addEventListener('click',this.deleteTarea);
        avanzarBtn.addEventListener('click',this.agregarDoing);
        avanzarBtn.addEventListener('click',this.deleteTarea);


        return componet;



    }

    
}



