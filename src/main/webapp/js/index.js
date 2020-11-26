


const tarea = document.getElementById('tarea');
const addTarea = document.getElementById('addTarea');
const etapa1Container = document.getElementById('Etapa1');
const etapa3Container = document.getElementById('Etapa3');


const  registrarTarea =()=> {

    let obj = {

        id:0,
        descripccion:tarea.value
        

    };
    console.log(JSON.stringify(obj));

    //[ara hacer el post]
    let xhr = new XMLHttpRequest();
    //response
    xhr.addEventListener('readystatechange',()=>{
        //readyStatae tiene varios estados el 5 estado es el complete 
        if(xhr.readyState===4){
            console.log(xhr.responseText);
            getAllTareas();
        }
        
    });
    //request
    xhr.open('POST','http://localhost:8080/Practico2/api/toDo/createTarea');
    xhr.setRequestHeader('Content-Type','application/json');
    //enciamos el objeto en string pero para mandaelo utlizamos JSON.stringfy();
    xhr.send( JSON.stringify(obj) );

};




addTarea.addEventListener('click',registrarTarea);

const getAllTareas =()=>{
        
    let xhr = new XMLHttpRequest();
     
    xhr.addEventListener('readystatechange', ()=>{

        if(xhr.readyState === 4){
            let json = xhr.responseText;
            //de json a objeto con el parse!!
            let response = JSON.parse(json);

            console.log(response);
            etapa1Container.innerHTML='';

            let title  =document.createElement('h1');
            title.innerHTML='ToDo';
            etapa1Container.appendChild(title);
            
            for(let i = 0; i<response.length ; i++){
            
                let ToDoDTO = response[i];
                let view = new ToDoView(ToDoDTO);
                view.getAllTareasDoing();//
                view .onDeleteFinish =()=>{
                    etapa1Container.removeChild(document.getElementById('todo'+ToDoDTO.id));
                };
                etapa1Container.appendChild(view.render());

            }          
                

        }

    })

    xhr.open('GET','http://localhost:8080/Practico2/api/toDo/allToDo');
    xhr.send();

};

const getAllTareasDone =()=> {
        
    let xhr = new XMLHttpRequest();
     
    xhr.addEventListener('readystatechange', ()=>{

        if(xhr.readyState === 4){
            let json = xhr.responseText;
            //de json a objeto con el parse!!
            let response = JSON.parse(json);

            console.log(response);
            etapa3Container.innerHTML='';

            let title  =document.createElement('h1');
            title.innerHTML='Done';
            etapa3Container.appendChild(title);
            
            for(let i = 0; i<response.length ; i++){
            
                let DoneDTO = response[i];
                let view = new DoneView(DoneDTO);
                view .onDeleteFinish =()=>{
                    etapa3Container.removeChild(document.getElementById('done'+DoneDTO.id));
                };
                etapa3Container.appendChild(view.render());

            }          
                

        }

    })

    xhr.open('GET','http://localhost:8080/Practico2/api/done/allDone');
    xhr.send();

    

};


getAllTareas();


getAllTareasDone();
