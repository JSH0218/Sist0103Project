//일반함수
function f1(){
    console.log("일반함수  f1");
}
f1();

//화살표
let f2=()=>console.log("화살표 함수 f2");
f2();

//일반
function f3(a,b){
    return a+b;
}

let=f3(5,7);
console.log(f3);

//화살표
let f4=(a,b)=>a+b; //한줄일땐 리턴 생략 가능
let b=f4(11,13);
console.log(b);

//일반
function f5(x,y,z=30){
    return x+y+z;
}

console.log(f5(1,2,3)); //6
console.log(f5(10,20)); //60

//화살표 f6으로구현
let f6=(x,y,z=30)=>x+y+z;
console.log(f6(1,2,3));
console.log(f6(10,20));

//오브젝트 함수를 객체로 만들수 있다
let ob={
    f1:()=>{
        console.log(1);

        let f2=()=>console.log(2);
        f2();

        setTimeout(f2,1000);
    }
}
ob.f1();