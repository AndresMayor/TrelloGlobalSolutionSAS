

class DoingView{

    etapa1Container = document.getElementById('Etapa1');
    etapa2Container = document.getElementById('Etapa2');
    etapa3Container = document.getElementById('Etapa3');

    constructor(doing){
        this.doing=doing;
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
        xhr.open('DELETE','http://localhost:8080/Practico2/api/Doing/delete/'+this.doing.id);
        xhr.send();

    }


    agregarDone =()=> {

        let obj = {

            id:0,
            descripccion:this.doing.descripccion,
            fecha:this.doing.fecha
        };
        console.log(JSON.stringify(obj));
    
        //[ara hacer el post]
        let xhr = new XMLHttpRequest();
        //response
        xhr.addEventListener('readystatechange',()=>{
            //readyStatae tiene varios estados el 5 estado es el complete 
            if(xhr.readyState===4){
                console.log(xhr.responseText);
                this.getAllTareasDone();
                
            }
            
        });
        //request
        xhr.open('POST','http://localhost:8080/Practico2/api/done/create');
        xhr.setRequestHeader('Content-Type','application/json');
        //enciamos el objeto en string pero para mandaelo utlizamos JSON.stringfy();
        xhr.send( JSON.stringify(obj) );



    }





    getAllTareasDone =()=> {
        
        let xhr = new XMLHttpRequest();
         
        xhr.addEventListener('readystatechange', ()=>{
    
            if(xhr.readyState === 4){
                let json = xhr.responseText;
                //de json a objeto con el parse!!
                let response = JSON.parse(json);
    
                console.log(response);
                this.etapa3Container.innerHTML='';
    
                let title  =document.createElement('h1');
                title.innerHTML='Done';
                this.etapa3Container.appendChild(title);
                
                for(let i = 0; i<response.length ; i++){
                
                    let DoneDTO = response[i];
                    let view = new DoneView(DoneDTO);
                    view .onDeleteFinish =()=>{
                        this.etapa3Container.removeChild(document.getElementById('done'+DoneDTO.id));
                    };
                    this.etapa3Container.appendChild(view.render());
    
                }          
                    
    
            }
    
        })
    
        xhr.open('GET','http://localhost:8080/Practico2/api/done/allDone');
        xhr.send();
    
        
    
    };

    agregarToDo =()=> {

        let obj = {

            id:0,
            descripccion:this.doing.descripccion,
            fecha:this.doing.fecha
    
        };
        console.log(JSON.stringify(obj));
    
        //[ara hacer el post]
        let xhr = new XMLHttpRequest();
        //response
        xhr.addEventListener('readystatechange',()=>{
            //readyStatae tiene varios estados el 5 estado es el complete 
            if(xhr.readyState===4){
                console.log(xhr.responseText);
                this.getAllToDo();
            }
            
        });
        //request
        xhr.open('POST','http://localhost:8080/Practico2/api/toDo/createTarea');
        xhr.setRequestHeader('Content-Type','application/json');
        //enciamos el objeto en string pero para mandaelo utlizamos JSON.stringfy();
        xhr.send( JSON.stringify(obj) );

    }



 getAllToDo =()=>{
        
    let xhr = new XMLHttpRequest();
     
    xhr.addEventListener('readystatechange', ()=>{

        if(xhr.readyState === 4){
            let json = xhr.responseText;
            //de json a objeto con el parse!!
            let response = JSON.parse(json);

            console.log(response);
            this.etapa1Container.innerHTML='';

            let title  =document.createElement('h1');
            title.innerHTML='ToDo';
            this.etapa1Container.appendChild(title);
            
            for(let i = 0; i<response.length ; i++){
            
                let ToDoDTO = response[i];
                let view = new ToDoView(ToDoDTO);
                view.getAllTareasDoing();//
                view .onDeleteFinish =()=>{
                this.etapa1Container.removeChild(document.getElementById('todo'+ToDoDTO.id));
                };
                this.etapa1Container.appendChild(view.render());

            }          
                

        }

     })
        xhr.open('GET','http://localhost:8080/Practico2/api/toDo/allToDo');
        xhr.send();

    };












    render =()=>{

        let componet = document.createElement('div');
        componet.id='doing'+this.doing.id;
        componet.className='doingComponent';

        let descripccion = document.createElement('p');
        descripccion.className='descripccionDoing';

        let fecha = document.createElement('small');
        let delBtn = document.createElement('button');
        let avanzarBtn = document.createElement('button');
        let atrazarBtn = document.createElement('button');
        
        delBtn.innerHTML='X';
        delBtn.className='delBtn';


        avanzarBtn.innerHTML='>';
        avanzarBtn.className='avanzarBtn';

        atrazarBtn.innerHTML='<';
        atrazarBtn.className='atrazarBtn';

        descripccion.innerHTML=this.doing.descripccion;
        fecha.innerHTML=this.doing.fecha;

        componet.appendChild(descripccion);
        componet.appendChild(fecha);
        componet.appendChild(delBtn);
        componet.appendChild(avanzarBtn);
        componet.appendChild(atrazarBtn);

        //comportamientos

        delBtn.addEventListener('click',this.deleteTarea);
        avanzarBtn.addEventListener('click',this.agregarDone);
        avanzarBtn.addEventListener('click',this.deleteTarea);
        atrazarBtn.addEventListener('click',this.agregarToDo);
        atrazarBtn.addEventListener('click',this.deleteTarea);


        return componet;



    }


     
}