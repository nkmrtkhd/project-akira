# Akira フォーマットとは #
Akiraに適したフォーマットです．

```
原子数，付加データ数，ボリュームデータの領域数，ボリュームデータ総数
h-matrix
species, x, y, z, data1, data2, ...
origin of volume1
h-matrix of volume1
volume1-data
...
origin of volume2
h-matrix of volume2
volume2-data
...
```
のように記述します．

# Fortran sample code: Akira format #
```
outfile='out000'
write(outfile(4:6),'(i3.3)') iframe
open(111,file=outfile)
write(111,'(4i10)')natm,ndata,nvolume,nvolume*nvx*nvy*nvz
write(111,'(3es16.8)')(h(1,i),i=1,3)
write(111,'(3es16.8)')(h(2,i),i=1,3)
write(111,'(3es16.8)')(h(3,i),i=1,3)
do i=1,natm
  adata(1)=temp(i)         !temperature
  adata(2)=pot(i)          !potential energy
  adata(3)=r(1,i)-r0(1,i)  !disp. x
  adata(4)=r(2,i)-r0(2,i)  !disp. y
  adata(5)=r(3,i)-r0(3,i)  !disp. z
  adata(6)=v(1,i)          !vel. x
  adata(7)=v(2,i)          !vel. y
  adata(8)=v(3,i)          !vel. z
  write(111,'(i5,20e17.7)')int(tag(i)),r(1:3,i),adata(1:ndata)
enddo

do iv=1,nvolume
write(111,'(3i10)')nvx(iv),nvy(iv),nvz(iv)
write(111,'(3es16.8)')ox(iv),oy(iv),oz(iv)
write(111,'(3es16.8)')(hv(1,i,iv),i=1,3)
write(111,'(3es16.8)')(hv(2,i,iv),i=1,3)
write(111,'(3es16.8)')(hv(3,i,iv),i=1,3)
do i=1,nvz
  do j=1,nvy
    do k=1,nvx
      write(111,'(3es16.8)')volumedata(k,j,i,iv)
    enddo
  enddo
enddo
close(222)

```
ここで
nvtot=sum_{i}^{nvblock} nvx(i) x nvy(i) x nvz(i)
である．_

# Fortran sample code: binary-Akira format #
openするときにformat='unformatted'を指定します．
```
outfile='out000'
write(outfile(4:6),'(i3.3)') iframe
open(111,file=outfile format='unformatted')
write(111,'(4i10)')natm,ndata,nvolume,nvolume*nvx*nvy*nvz
write(111,'(3es16.8)')(h(1,i),i=1,3)
write(111,'(3es16.8)')(h(2,i),i=1,3)
write(111,'(3es16.8)')(h(3,i),i=1,3)
do i=1,natm
  adata(1)=temp(i)
  adata(2)=pot(i)
  adata(3)=r(1,i)-r0(1,i)
  adata(4)=r(2,i)-r0(2,i)
  adata(5)=r(3,i)-r0(3,i)
  adata(6)=v(1,i)
  adata(7)=v(2,i)
  adata(8)=v(3,i)
  write(111,'(i5,20e17.7)')int(tag(i)),r(1:3,i),adata(1:ndata)
enddo

do iv=1,nvolume
write(111,'(3i10)')nvx(iv),nvy(iv),nvz(iv)
write(111,'(3es16.8)')ox(iv),oy(iv),oz(iv)
write(111,'(3es16.8)')(hv(1,i,iv),i=1,3)
write(111,'(3es16.8)')(hv(2,i,iv),i=1,3)
write(111,'(3es16.8)')(hv(3,i,iv),i=1,3)
do i=1,nvz
  do j=1,nvy
    do k=1,nvx
      write(111,'(3es16.8)')volumedata(k,j,i,iv)
    enddo
  enddo
enddo
close(222)
```